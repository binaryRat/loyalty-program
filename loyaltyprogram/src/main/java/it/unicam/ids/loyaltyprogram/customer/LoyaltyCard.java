package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.manager.LoyaltyProgram;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class LoyaltyCard implements Card<LoyaltyProgram, PointsPerProgram> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PointsPerProgram> points = new ArrayList<>();

    @Override
    public void addPoints(LoyaltyProgram program, Integer value) {

    }
    @Override
    public void removePoints(LoyaltyProgram program, Integer value) {

    }
    @Override
    public List<PointsPerProgram> getPoints() {
        return points;
    }
}
