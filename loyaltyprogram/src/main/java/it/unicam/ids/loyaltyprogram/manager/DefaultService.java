package it.unicam.ids.loyaltyprogram.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DefaultService implements Service{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer cost;
    private String code;
    public DefaultService(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
        //TODO creazione randomica del codice
        this.code = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    }

    @Override
    public String getCode() {
        return code;
    }
}
