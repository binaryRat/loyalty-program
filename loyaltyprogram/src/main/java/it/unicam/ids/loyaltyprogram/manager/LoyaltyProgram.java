package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Module;

import java.util.List;

public class LoyaltyProgram implements Program {

    private List<Product> products;
    private List<Service> services;
    private Module module;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void addProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void addService(Service service) {
        this.services.add(service);
    }

    @Override
    public Module getData() {
        return this.module;
    }

    @Override
    public void setData(Module module) {
        this.module = module;
    }
}
