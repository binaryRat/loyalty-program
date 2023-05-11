package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.customer.LoyaltyCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultBusinessTest {

    @Test
    void addStore() {
        DefaultBusiness business = new DefaultBusiness();
        DefaultStore store = new DefaultStore();
        business.addStore(store);
        assertEquals(business.getStores().get(0), store);
    }

    @Test
    void addProgram() {
        DefaultBusiness business = new DefaultBusiness();
        LoyaltyProgram program1 = new LoyaltyProgram();
        LoyaltyProgram program2 = new LoyaltyProgram();
        business.addProgram(program1);
        business.addProgram(program2);
        assertEquals(business.getPrograms().get(0), program1);
        assertEquals(business.getPrograms().get(1), program2);
    }

    @Test
    void generateCard() {
        DefaultBusiness business = new DefaultBusiness();
        System.out.println(business.generateCard().getClass());
        assertTrue(business.generateCard().getClass().equals(LoyaltyCard.class));
    }

    @Test
    void getProgramById() {
        DefaultBusiness business = new DefaultBusiness();
        LoyaltyProgram program1 = new LoyaltyProgram();
        LoyaltyProgram program2 = new LoyaltyProgram();
        program1.setId(1);
        program2.setId(2);
        business.addProgram(program1);
        business.addProgram(program2);
        assertEquals(business.getProgramById(1).get(), program1);
        assertEquals(business.getProgramById(2).get(), program2);
    }

    @Test
    void setOwner() {
        DefaultBusiness business = new DefaultBusiness();
        BusinessManager manager = new BusinessManager();
        business.setOwner(manager);
        assertEquals(business.getOwner(), manager);
    }
}