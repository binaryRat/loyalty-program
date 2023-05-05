package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.manager.BusinessService;
import it.unicam.ids.loyaltyprogram.manager.DefaultBusiness;
import it.unicam.ids.loyaltyprogram.manager.LoyaltyProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerRestController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private CustomerService customerService;
    @PostMapping(value = "/addCard", consumes = "application/json", produces = "application/json")
    public Customer addCard(@RequestBody Map<String, Integer> body, @RequestHeader HashMap<String, String> headers){
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
        customer.addCard(business.genereteCard());
        return customer;
    }
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public String createUser(@RequestBody Customer body){
        customerService.writeCustomer(body);
        return "Customer created";
    }
}
