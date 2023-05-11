package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.core.Module;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Map;

@Entity
public class InformationModule implements Module {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name = "";
    private String description = "";
    public InformationModule(){};
    public InformationModule(Map<String, String> data){
        this.name = data.get("name");
        this.description = data.get("description");
    }

    @Override
    public boolean checkParameters() {
        if(name.isBlank()) return false;
        if(description.isBlank()) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
