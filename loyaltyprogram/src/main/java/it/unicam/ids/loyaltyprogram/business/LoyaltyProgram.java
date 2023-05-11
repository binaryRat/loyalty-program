package it.unicam.ids.loyaltyprogram.business;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class LoyaltyProgram implements Program<DefaultProduct, DefaultService, InformationModule> {
    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<DefaultProduct> products = new ArrayList<>();

    public List<DefaultService> getServices() {
        return services;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    private List<DefaultService> services = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL})
    private InformationModule module;

    public Integer getId() {
        return id;
    }

    public LoyaltyProgram(){};
    @Override
    public List<DefaultProduct> getProducts() {
        return products;
    }

    @Override
    public void addProducts(List<DefaultProduct> products) {
        this.products = products;
    }

    @Override
    public void addService(DefaultService service) {
        this.services.add(service);
    }

    @Override
    public InformationModule getModule() {
        return this.module;
    }

    @Override
    public void setModule(InformationModule module) {
        this.module = module;
    }

    public Optional<DefaultService> getServiceById(Integer id) {
        return getServices().stream().filter((s)->s.getId().equals(id)).findFirst();
    }
}
