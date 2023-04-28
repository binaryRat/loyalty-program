package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Module;
import jakarta.persistence.*;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;

import java.util.List;

@Entity
public class LoyaltyProgram implements Program<DefaultProduct, DefaultService, BusinessInformationModule> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private List<DefaultProduct> products;
    @OneToMany
    private List<DefaultService> services;

    @OneToOne
    private BusinessInformationModule module;

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
    public BusinessInformationModule getData() {
        return this.module;
    }

    @Override
    public void setData(BusinessInformationModule module) {
        this.module = module;
    }
}
