package it.unicam.ids.loyaltyprogram.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyProgramTest {

    @Test
    void addProducts() {
        LoyaltyProgram  program = new LoyaltyProgram();
        DefaultProduct product = new DefaultProduct();
        ArrayList<DefaultProduct> products = new ArrayList<>();
        products.add(product);
        program.addProducts(products);
        assertEquals(program.getProducts(),products);
    }

    @Test
    void addService() {
        LoyaltyProgram  program = new LoyaltyProgram();
        DefaultService service = new DefaultService();
        program.addService(service);
        assertEquals(program.getServices().get(0), service);
    }

    @Test
    void setModule() {
        LoyaltyProgram  program = new LoyaltyProgram();
        InformationModule module = new InformationModule();
        program.setModule(module);
        assertEquals(program.getModule(),module);

    }

    @Test
    void getServiceById() {
        LoyaltyProgram  program = new LoyaltyProgram();
        DefaultService service = new DefaultService();
        service.setId(1);
        program.addService(service);
        assertEquals(service, program.getServiceById(1).get());
    }
}