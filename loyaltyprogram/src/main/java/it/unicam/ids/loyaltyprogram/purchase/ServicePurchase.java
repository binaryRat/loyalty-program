package it.unicam.ids.loyaltyprogram.purchase;

import jakarta.persistence.Entity;

@Entity
public class ServicePurchase extends DefaultPurchase{

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    private Integer programId;
}
