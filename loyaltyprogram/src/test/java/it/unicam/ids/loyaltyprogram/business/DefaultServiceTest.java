package it.unicam.ids.loyaltyprogram.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultServiceTest {

    @Test
    void setName() {
        DefaultService service = new DefaultService();
        String name = "NameTest";
        service.setName(name);
        assertEquals(service.getName(),name);
    }

    @Test
    void setCost() {
        DefaultService service = new DefaultService();
        Integer cost = 20;
        service.setCost(cost);
        assertEquals(service.getCost(),cost);
    }
}