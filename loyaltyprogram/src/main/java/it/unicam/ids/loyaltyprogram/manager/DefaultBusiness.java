package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Module;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class DefaultBusiness implements Business<BusinessInformationModule,DefaultStore,LoyaltyProgram>{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private List<DefaultStore> stores = new ArrayList<>();
    //@OneToMany
    //private List<LoyaltyProgram> programs = new ArrayList<>();

    @OneToOne
    private BusinessInformationModule module;
    @Override
    public void addStore(DefaultStore store) {
        stores.add(store);
    }

    @Override
    public BusinessInformationModule getData() {
        return this.module;
    }

    @Override
    public void setData(BusinessInformationModule module) {
        this.module = module;
    }

    @Override
    public List<LoyaltyProgram> getPrograms() {
        return null;
    }
    @Override
    public List<DefaultStore> getStores() {
        return stores;
    }
}
