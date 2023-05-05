package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.manager.Program;

import java.util.List;

public interface Card<P extends Program, O extends Points> {
    void addPoints(P program, Integer value);
    void removePoints(P program, Integer value);
    List<O> getPoints();
}
