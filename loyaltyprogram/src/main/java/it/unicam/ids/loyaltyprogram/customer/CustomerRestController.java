package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.business.BusinessService;
import it.unicam.ids.loyaltyprogram.business.DefaultBusiness;
import it.unicam.ids.loyaltyprogram.business.DefaultService;
import it.unicam.ids.loyaltyprogram.purchase.DefaultPurchase;
import it.unicam.ids.loyaltyprogram.purchase.PurchaseService;
import it.unicam.ids.loyaltyprogram.purchase.ServicePurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerRestController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/addCard", consumes = "application/json", produces = "application/json")
    public String addCard(@RequestBody Map<String, Integer> body, @RequestHeader HashMap<String, String> headers){
        Optional<DefaultBusiness> optionalBusiness = businessService.getBusiness(body.get("businessId"));
        if(!optionalBusiness.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
        DefaultBusiness business = optionalBusiness.get();

        Optional<Customer> optionalCustomer = customerService.getCustomer(Integer.valueOf(headers.get("userid")));
        if(!optionalCustomer.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer not found"
        );
        Customer customer = optionalCustomer.get();
        customer.addCard(business.generateCard());
        customerService.writeCustomer(customer);
        return "Card added";
    }
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public String createUser(@RequestBody Customer body){
        customerService.writeCustomer(body);
        return "Customer created";
    }

    @PostMapping(value = "/collect", consumes = "application/json", produces = "application/json")
    public Customer collectPurchase(@RequestBody Map<String, String> body, @RequestHeader HashMap<String, String> headers){
        Integer businessId = Integer.valueOf(body.get("businessId"));
        Integer userId = Integer.valueOf(headers.get("userid"));
        Optional<DefaultPurchase> optionalPurchase = purchaseService.getPurchaseByCode(businessId,"product", body.get("code"));

        if(!optionalPurchase.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Purchase not found"
        );
        DefaultPurchase purchase = optionalPurchase.get();
        List<Integer> pointsToAdd = purchase.getProductsCodes().stream()
                .map((code)-> businessService.getProductByCode(businessId, code).getPoints())
                .toList();

        Optional<Customer> optionalCustomer = customerService.getCustomer(userId);
        if(!optionalCustomer.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer not found"
        );
        Customer customer = optionalCustomer.get();
        customer.getCards().forEach((card)->{
            if (card.getBusinessId().equals(businessId)){
                pointsToAdd.forEach((points)->card.addPoints(points));
            }
        });
        purchase.consume();
        customerService.writeCustomer(customer);
        purchaseService.writePurchase(purchase);
        return customer;
    }
    @PostMapping(value = "/buyService", consumes = "application/json", produces = "application/json")
    public ServicePurchase buyService(@RequestBody Map<String, String> body, @RequestHeader HashMap<String, String> headers){
        Integer businessId = Integer.valueOf(body.get("businessId"));
        Integer programId = Integer.valueOf(body.get("programId"));
        Integer serviceId = Integer.valueOf(body.get("serviceId"));
        Integer userId = Integer.valueOf(headers.get("userid"));

        Optional<Customer> optionalCustomer = customerService.getCustomer(userId);
        if(!optionalCustomer.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer not found"
        );
        Customer customer = optionalCustomer.get();
        Optional<DefaultBusiness> optionalBusiness = businessService.getBusiness(businessId);
        if(!optionalBusiness.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
        DefaultService service = optionalBusiness.get().getProgramById(programId).get().getServiceById(serviceId).get();

        for(LoyaltyCard card: customer.getCards()){
            if (card.getBusinessId().equals(businessId)){
                if(card.getPoints()<service.getCost()){
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Insufficient points amount"
                    );
                }else{
                    card.removePoints(service.getCost());
                }
                break;
            }
        }

        ServicePurchase servicePurchase = new ServicePurchase();
        servicePurchase.setType("service");
        servicePurchase.setCode(generateRandomCode().toString());
        servicePurchase.setBusinessId(businessId);
        servicePurchase.setProductsCodes(new ArrayList<>(serviceId));
        servicePurchase.setProgramId(programId);

        customerService.writeCustomer(customer);
        purchaseService.writeServicePurchase(servicePurchase);
        return servicePurchase;
    }
    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong | variant3BitFlag;
    }
    private static long get64MostSignificantBitsForVersion1() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long time_low = (currentTimeMillis & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((currentTimeMillis >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12;
        final long time_hi = ((currentTimeMillis >> 48) & 0x0FFF);
        return time_low | time_mid | version | time_hi;
    }
    private static UUID generateRandomCode() {
        long most64SigBits = get64MostSignificantBitsForVersion1();
        long least64SigBits = get64LeastSignificantBitsForVersion1();
        return new UUID(most64SigBits, least64SigBits);
    }

}
