package it.unicam.ids.loyaltyprogram.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DefaultStore implements Store{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String position;

    public Integer getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setPosition(String position) {
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }

}
