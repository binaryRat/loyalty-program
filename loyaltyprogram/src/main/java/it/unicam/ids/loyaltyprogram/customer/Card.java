package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.business.Program;

import java.util.List;

public interface Card {
    void addPoints(Integer value);
    void removePoints(Integer value);
    Integer getPoints();
}
