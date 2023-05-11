package it.unicam.ids.loyaltyprogram.business;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultProductTest {

    @Test
    void setName() {
        DefaultProduct product = new DefaultProduct();
        String name = "NameTest";
        product.setName(name);
        assertEquals(product.getName(),name);
    }

    @Test
    void setCode() {
        DefaultProduct product = new DefaultProduct();
        String code = "123123123123123";
        product.setCode(code);
        assertEquals(product.getCode(),code);
    }

    @Test
    void setPoints() {
        DefaultProduct product = new DefaultProduct();
        Integer points = 20;
        product.setPoints(points);
        assertEquals(product.getPoints(),points);
    }
}