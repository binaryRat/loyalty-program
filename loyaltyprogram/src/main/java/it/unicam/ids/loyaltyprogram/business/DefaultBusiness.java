package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.customer.LoyaltyCard;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
public class DefaultBusiness implements Business<InformationModule,DefaultStore,LoyaltyProgram>{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<DefaultStore> stores = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.ALL})
    private List<LoyaltyProgram> programs = new ArrayList<>();
    @OneToOne(cascade = {CascadeType.ALL})
    private InformationModule module;
    public Integer getId() {
        return id;
    }
    @Override
    public void addStore(DefaultStore store) {
        stores.add(store);
    }

    @Override
    public InformationModule getModule() {
        return this.module;
    }

    @Override
    public void setModule(InformationModule module) {
        this.module = module;
    }

    @Override
    public List<LoyaltyProgram> getPrograms() {
        return programs;
    }
    @Override
    public List<DefaultStore> getStores() {
        return stores;
    }
    @Override
    public void addProgram(LoyaltyProgram program) {
        programs.add(program);
    }

    public LoyaltyCard generateCard() {
        return new LoyaltyCard(getId());
    }

    public Optional<LoyaltyProgram> getProgramById(Integer id) {
        return getPrograms().stream().filter((p)->p.getId().equals(id)).findFirst();
    }
}
