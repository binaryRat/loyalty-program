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
    public DefaultBusiness createBusiness(@RequestBody DefaultBusiness business, @RequestHeader HashMap<String, String> headers){
        business.setOwnerId(Integer.valueOf(headers.get("userId")));
        if(!business.getModule().checkParameters()){
            throw new InvalidParameterException("One of the input parameter is empty");
        };
        service.writeBusiness(business);
        return business;
    }
    @GetMapping(value = "/businesses", produces = "application/json")
    public List<DefaultBusiness> listBusinesses(){
        ArrayList<DefaultBusiness> businesses = service.getBusinesses();
        return businesses;
    }
    @GetMapping(value = "/businesses/{id}", produces = "application/json")
    public DefaultBusiness getBusiness(@PathVariable Integer id){
        Optional<DefaultBusiness> businesses = service.getBusiness(id);
        return businesses.get();
    }
    @PostMapping(value = "/businesses/{id}/programs", consumes = "application/json", produces = "application/json")
    public DefaultBusiness addProgramToBusiness(@PathVariable Integer id, @RequestBody LoyaltyProgram program){
        Optional<DefaultBusiness> optionalBusiness = service.getBusiness(id);
        if(!optionalBusiness.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
        DefaultBusiness business = optionalBusiness.get();
        business.addProgram(program);
        service.writeBusiness(business);
        return business;
    }
    @GetMapping(value = "/businesses/{id}/programs", produces = "application/json")
    public List<LoyaltyProgram> listBusinessPrograms(@PathVariable Integer id){
        Optional<DefaultBusiness> business = service.getBusiness(id);
        if(business.isPresent()) return business.get().getPrograms();
        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
    }
    @GetMapping(value = "/businesses/{id}/programs/{programId}", produces = "application/json")
    public LoyaltyProgram getProgram(@PathVariable Integer id, @PathVariable Integer programId){
        Optional<DefaultBusiness> business = service.getBusiness(id);
        if(business.isPresent()) return business.get().getProgramById(programId).get();
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
    public DefaultBusiness getMyBusinesses(@RequestHeader HashMap<String, String> headers){
        ArrayList<DefaultBusiness> businesses = service.getBusinesses();
        Optional<DefaultBusiness> business = businesses.stream().filter((b)->b.getOwnerId().equals(Integer.valueOf(headers.get("userId")))).findFirst();
        if(business.isPresent()) return business.get();
        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
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
