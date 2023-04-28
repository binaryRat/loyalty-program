package it.unicam.ids.loyaltyprogram.manager;
import it.unicam.ids.loyaltyprogram.templates.BusinessTemplate;

import it.unicam.ids.loyaltyprogram.templates.ProgramTemplate;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequestMapping(path = "/api/manager")
public class ManagerRestController {
    @Autowired
    private BusinessService writer;
    @PostMapping(value = "/businesses", consumes = "application/json", produces = "application/json")
    public String createBusiness(@RequestBody BusinessTemplate body, HttpServletResponse response){
        BusinessController controller = new BusinessController();
        try{
            DefaultBusiness business = controller.createNewBusiness(new BusinessInformationModule(body.getModule()), body.getStores());
            writer.writeBusiness(business);
        }catch (InvalidParameterException e){
            return "Invalid parameter";
        }

        return "Business created";
    }
    @GetMapping(value = "/businesses", produces = "application/json")
    public String listBusinesses(HttpServletResponse response){
        return "";
    }
    @PostMapping(value = "/businesses/{id}/programs", consumes = "application/json", produces = "application/json")
    public String addProgramToBusiness(@RequestBody ProgramTemplate body, HttpServletResponse response){
        return "";
    }
    @GetMapping(value = "/businesses/{id}/programs", produces = "application/json")
    public String listBusinessPrograms(HttpServletResponse response){
        return "";
    }
}
