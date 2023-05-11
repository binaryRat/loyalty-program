package it.unicam.ids.loyaltyprogram.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void setName() {
        Customer customer = new Customer();
        String name = "Name";
        customer.setName(name);
        assertEquals(customer.getName(), name);
    }

    @Test
    void setSurname() {
        Customer customer = new Customer();
        String surname = "Surname";
        customer.setSurname(surname);
        assertEquals(customer.getSurname(), surname);
    }

    @Test
    void setEmail() {
        Customer customer = new Customer();
        String email = "Email";
        customer.setEmail(email);
        assertEquals(customer.getEmail(), email);
    }

    @Test
    void setPassword() {
        Customer customer = new Customer();
        String password = "Password";
        customer.setPassword(password);
        assertEquals(customer.getPassword(), password);
    }

    @Test
    void addCard() {
        Customer customer = new Customer();
        LoyaltyCard card = new LoyaltyCard();
        customer.addCard(card);
        assertEquals(customer.getCards().get(0), card);
    }
}