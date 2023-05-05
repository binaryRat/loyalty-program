package it.unicam.ids.loyaltyprogram.purchase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class DefaultPurchase implements Purchase{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String code;
    private List<String> productsCodes;

    private Boolean consumed;

    public DefaultPurchase() {
        this.consumed = false;
    }
    public List<String> getProductsCodes() {
        return productsCodes;
    }

    public void setProductsCodes(List<String> productsCodes) {
        this.productsCodes = productsCodes;
    }
    public Boolean getConsumed() {
        return consumed;
    }

    public void consume() {
        this.consumed = false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
