package it.unicam.ids.loyaltyprogram.purchase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicePurchaseTest {

    @Test
    void setProgramId() {
        ServicePurchase purchase =  new ServicePurchase();
        purchase.setProgramId(1);
        assertEquals(purchase.getProgramId(),1);
    }
}