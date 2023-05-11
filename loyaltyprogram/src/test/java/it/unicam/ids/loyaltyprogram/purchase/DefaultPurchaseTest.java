package it.unicam.ids.loyaltyprogram.purchase;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultPurchaseTest {

    @Test
    void setType() {
        DefaultPurchase purchase = new DefaultPurchase();
        String type = "product";
        purchase.setType(type);
        assertEquals(purchase.getType(), type);
    }

    @Test
    void setProductsCodes() {
        DefaultPurchase purchase = new DefaultPurchase();
        List<String> codes = new ArrayList<>();
        codes.add("123123");
        codes.add("23232323");
        purchase.setProductsCodes(codes);
        assertEquals(purchase.getProductsCodes().get(0),"123123");
        assertEquals(purchase.getProductsCodes().get(1),"23232323");
    }

    @Test
    void consume() {
        DefaultPurchase purchase = new DefaultPurchase();
        assertFalse(purchase.getConsumed());
        purchase.consume();
        assertTrue(purchase.getConsumed());
    }

    @Test
    void setCode() {
        DefaultPurchase purchase = new DefaultPurchase();
        String code = "123123123";
        purchase.setCode(code);
        assertEquals(purchase.getCode(), code);
    }

    @Test
    void setBusinessId() {
        DefaultPurchase purchase = new DefaultPurchase();
        Integer businessId = 1;
        purchase.setBusinessId(businessId);
        assertEquals(purchase.getBusinessId(), businessId);
    }
}