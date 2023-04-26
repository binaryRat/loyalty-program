package it.unicam.ids.loyaltyprogram.manager;
import it.unicam.ids.loyaltyprogram.templates.BusinessTemplate;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.InvalidParameterException;

@RestController
@RequestMapping(path = "/api/manager")
public class ManagerRestController {
    @Autowired
    private BusinessService writer;
    @PostMapping(value = "/create/business", consumes = "application/json", produces = "application/json")
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
}
