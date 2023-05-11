package it.unicam.ids.loyaltyprogram.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultStoreTest {

    @Test
    void setName() {
        DefaultStore store = new DefaultStore();
        String name = "NomeStore123";
        store.setName(name);
        assertEquals(store.getName(),name);
    }

    @Test
    void setPosition() {
        DefaultStore store = new DefaultStore();
        String position = "ViaRoma12";
        store.setPosition(position);
        assertEquals(store.getPosition(),position);
    }
}