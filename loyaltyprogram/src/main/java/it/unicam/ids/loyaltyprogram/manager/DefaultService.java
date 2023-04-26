package it.unicam.ids.loyaltyprogram.manager;

public class DefaultService implements Service{
    private String name;
    private Integer cost;
    public DefaultService(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }
}
