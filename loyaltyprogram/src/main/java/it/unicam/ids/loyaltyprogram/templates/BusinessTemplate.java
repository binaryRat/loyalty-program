package it.unicam.ids.loyaltyprogram.templates;

import it.unicam.ids.loyaltyprogram.manager.DefaultStore;
import it.unicam.ids.loyaltyprogram.manager.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BusinessTemplate {
    private HashMap<String,String> module;
    private List<DefaultStore> stores;

    public List<DefaultStore> getStores() {
        return stores;
    }

    public HashMap<String, String> getModule() {
        return module;
    }
}
