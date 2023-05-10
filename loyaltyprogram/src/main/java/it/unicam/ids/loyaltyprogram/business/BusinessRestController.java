package it.unicam.ids.loyaltyprogram.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/manager")
public class BusinessRestController {
    @Autowired
    private BusinessService service;
    @PostMapping(value = "/businesses", consumes = "application/json", produces = "application/json")
    public String createBusiness(@RequestBody DefaultBusiness body, @RequestHeader HashMap<String, String> headers){
        //TODO set del owner al business
        try{
            if(!body.getModule().checkParameters()){
                throw new InvalidParameterException("One of the input parameter is empty");
            };
            service.writeBusiness(body);
        }catch (InvalidParameterException e){
            return "Invalid parameter";
        }
        return "Business created";
    }
    @GetMapping(value = "/businesses", produces = "application/json")
    public List<DefaultBusiness> listBusinesses(){
        ArrayList<DefaultBusiness> businesses = service.getBusinesses();
        return businesses;
    }
    @PostMapping(value = "/businesses/{id}/programs", consumes = "application/json", produces = "application/json")
    public String addProgramToBusiness(@PathVariable Integer id, @RequestBody LoyaltyProgram program){
        Optional<DefaultBusiness> optionalBusiness = service.getBusiness(id);
        if(!optionalBusiness.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
        DefaultBusiness business = optionalBusiness.get();
        business.addProgram(program);
        service.writeBusiness(business);
        return "Program created";
    }
    @GetMapping(value = "/businesses/{id}/programs", produces = "application/json")
    public List<LoyaltyProgram> listBusinessPrograms(@PathVariable Integer id){
        Optional<DefaultBusiness> business = service.getBusiness(id);
        if(business.isPresent()) return business.get().getPrograms();
        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
    }
    @GetMapping(value = "/search/product", produces = "application/json")
    public DefaultProduct getProductByCode(@RequestParam String code, @RequestParam Integer businessId){
        DefaultProduct product = service.getProductByCode(businessId,code);
        return product;
    }
    @GetMapping(value = "/search/owned", produces = "application/json")
    public List<DefaultBusiness> getMyBusinesses(@RequestParam String code, @RequestParam Integer businessId){
       //TODO
        return null;
    }

    private ArrayList<DefaultProduct> getProducts(DefaultBusiness business, LoyaltyProgram program){
        List<DefaultProduct> businessProducts = business.getPrograms()
                .stream()
                .flatMap((p) -> p.getProducts().stream()).toList();
        ArrayList<DefaultProduct> products = new ArrayList<>();
        program.getProducts().forEach((product) -> {
            Optional<DefaultProduct> foundProduct = businessProducts.stream().filter((p) -> p.getCode()==product.getCode()).findFirst();
            if(!foundProduct.isPresent()) products.add(product);
            else new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Can't add the same product to different programs"
            );
        });
        return products;
    }
}
