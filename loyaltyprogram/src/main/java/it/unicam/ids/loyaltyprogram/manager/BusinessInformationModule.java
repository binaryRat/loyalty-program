package it.unicam.ids.loyaltyprogram.manager;

import it.unicam.ids.loyaltyprogram.Module;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.security.InvalidParameterException;
import java.util.Map;

@Entity
public class BusinessInformationModule implements Module {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    public BusinessInformationModule(Map<String, String> data){
        if(!checkParameters(data)){
            throw new InvalidParameterException("One of the input parameter is empty");
        };
        this.name = data.get("name");
        this.description = data.get("description");
    }

    @Override
    public boolean checkParameters(Map<String, String> data) {
        if(data.get("name").isBlank()) return false;
        if(data.get("description").isBlank()) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
