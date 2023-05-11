package it.unicam.ids.loyaltyprogram.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyCardTest {

    @Test
    void addPoints() {
        LoyaltyCard card =  new LoyaltyCard();
        card.addPoints(20);
        assertEquals(card.getPoints(), 20);
        card.addPoints(20);
        assertEquals(card.getPoints(), 40);
    }

    @Test
    void removePoints() {
        LoyaltyCard card =  new LoyaltyCard();
        card.removePoints(20);
        assertEquals(card.getPoints(), -20);
        card.addPoints(20);
        assertEquals(card.getPoints(), 0);
    }
}