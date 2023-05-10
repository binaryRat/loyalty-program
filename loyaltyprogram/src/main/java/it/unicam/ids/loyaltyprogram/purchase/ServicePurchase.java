package it.unicam.ids.loyaltyprogram.purchase;

import jakarta.persistence.Entity;

@Entity
public class ServicePurchase extends DefaultPurchase{
    private Integer programId;

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }


}
