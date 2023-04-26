package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Factory;
import it.unicam.ids.loyaltyprogram.Module;

public class DefaultBusinessFactory implements Factory<Business> {
    private DefaultBusiness business;
    DefaultBusinessFactory(){
        this.business = new DefaultBusiness();
    }

    public void addStore(DefaultStore store){
        business.addStore(store);
    }

    public void addInformation(BusinessInformationModule module){
        business.setData(module);
    }

    @Override
    public DefaultBusiness build() {
        return business;
    }
}
