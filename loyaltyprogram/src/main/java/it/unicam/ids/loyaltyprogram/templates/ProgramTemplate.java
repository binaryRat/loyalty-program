package it.unicam.ids.loyaltyprogram.templates;

import it.unicam.ids.loyaltyprogram.manager.DefaultProduct;
import it.unicam.ids.loyaltyprogram.manager.DefaultService;
import it.unicam.ids.loyaltyprogram.manager.DefaultStore;

import java.util.HashMap;
import java.util.List;

public class ProgramTemplate {
    private HashMap<String,String> module;
    private List<DefaultProduct> products;
    private List<DefaultService> services;

    public List<DefaultProduct> getProducts() {
        return products;
    }
    public HashMap<String, String> getModule() {
        return module;
    }

    public List<DefaultService> getServices() {
        return services;
    }
}
