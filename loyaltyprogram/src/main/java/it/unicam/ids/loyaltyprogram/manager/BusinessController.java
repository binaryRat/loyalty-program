package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Controller;
import it.unicam.ids.loyaltyprogram.Module;

import java.util.List;
import java.util.Map;

public class BusinessController implements Controller {

    public DefaultBusiness createNewBusiness(BusinessInformationModule module, List<DefaultStore> stores){

        DefaultBusinessFactory factory = new DefaultBusinessFactory();
        stores.forEach((store) ->{
            factory.addStore(store);
        });
        factory.setInformation(module);
        return factory.build();
    }

    public LoyaltyProgram createNewProgram(BusinessInformationModule module, List<DefaultProduct> products, Map<String, Integer> services){
        LoyaltyProgram program = new LoyaltyProgram();
        program.setData(module);
        program.addProducts(products);
        services.forEach((name, cost) ->{
            DefaultService service = new DefaultService(name,cost);
            program.addService(service);
        });
        return program;
    }
}
