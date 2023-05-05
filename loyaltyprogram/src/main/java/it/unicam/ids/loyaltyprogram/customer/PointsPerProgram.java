package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.manager.LoyaltyProgram;
import jakarta.persistence.*;

@Entity
public class PointsPerProgram implements Points{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = {CascadeType.ALL})
    private LoyaltyProgram program;

    private Integer amount;
}
