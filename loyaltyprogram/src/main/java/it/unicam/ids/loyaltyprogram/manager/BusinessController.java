package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Controller;

import java.util.List;

public class BusinessController implements Controller {

    public DefaultBusiness createNewBusiness(InformationModule module, List<DefaultStore> stores){

        DefaultBusinessFactory factory = new DefaultBusinessFactory();
        stores.forEach((store) ->{
            factory.addStore(store);
        });
        factory.setInformation(module);
        return factory.build();
    }

    public LoyaltyProgram createNewProgram(InformationModule module, List<DefaultProduct> products, List<DefaultService> services){
        LoyaltyProgram program = new LoyaltyProgram();
        program.setModule(module);
        program.addProducts(products);
        services.forEach((service) ->{
            program.addService(service);
        });
        return program;
    }
}
