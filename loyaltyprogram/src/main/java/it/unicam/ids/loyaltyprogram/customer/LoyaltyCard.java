package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.business.LoyaltyProgram;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class LoyaltyCard implements Card {
    public Integer getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer points = 0;
    private Integer businessId;
    public LoyaltyCard(){}
    public LoyaltyCard(Integer businessId){
        this.businessId = businessId;
    }

    @Override
    public void addPoints(Integer value) {
        this.points += value;
    }
    @Override
    public void removePoints(Integer value) {
        this.points -= value;
    }
    @Override
    public Integer getPoints() {
        return points;
    }
    public Integer getBusinessId() {
        return businessId;
    }
}
