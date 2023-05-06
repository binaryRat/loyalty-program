package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.core.Factory;

public class DefaultBusinessFactory implements Factory<Business> {
    private DefaultBusiness business;
    DefaultBusinessFactory(){
        this.business = new DefaultBusiness();
    }

    public void addStore(DefaultStore store){
        business.addStore(store);
    }

    public void setInformation(InformationModule module){
        business.setModule(module);
    }

    @Override
    public DefaultBusiness build() {
        return business;
    }
}
