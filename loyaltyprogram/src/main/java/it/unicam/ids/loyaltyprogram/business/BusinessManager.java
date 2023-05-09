package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.core.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusinessManager implements User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
}
