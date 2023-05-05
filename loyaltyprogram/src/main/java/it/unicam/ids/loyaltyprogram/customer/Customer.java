package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.core.User;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Customer implements User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<LoyaltyCard> cards;
    private String name;
    private String surname;
    private String email;
    private String password;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addCard(LoyaltyCard card){
        cards.add(card);
    }
    public List<LoyaltyCard> getCards() {
        return cards;
    }
}
