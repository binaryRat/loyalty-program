package it.unicam.ids.loyaltyprogram.manager;
import it.unicam.ids.loyaltyprogram.templates.BusinessTemplate;

import it.unicam.ids.loyaltyprogram.templates.ProgramTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/manager")
public class ManagerRestController {
    @Autowired
    private BusinessService service;
    @PostMapping(value = "/businesses", consumes = "application/json", produces = "application/json")
    public String createBusiness(@RequestBody BusinessTemplate body){
        BusinessController controller = new BusinessController();
        try{
            DefaultBusiness business = controller.createNewBusiness(new InformationModule(body.getModule()), body.getStores());
            service.writeBusiness(business);
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
    public String addProgramToBusiness(@PathVariable Integer id, @RequestBody ProgramTemplate body){
        Optional<DefaultBusiness> optionalBusiness = service.getBusiness(id);
        if(!optionalBusiness.isPresent()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Business not found"
        );
        DefaultBusiness business = optionalBusiness.get();
        ArrayList<DefaultProduct> products = getProducts(business, body);
        BusinessController controller = new BusinessController();
        LoyaltyProgram program = controller.createNewProgram(new InformationModule(body.getModule()),body.getProducts(),body.getServices());
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

    private ArrayList<DefaultProduct> getProducts(DefaultBusiness business, ProgramTemplate program){
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
        /*try{

        }catch (InvalidParameterException e){
            throw
        }*/
    }
}
