package it.unicam.ids.loyaltyprogram.purchase;

import it.unicam.ids.loyaltyprogram.core.PurchaseRepository;
import it.unicam.ids.loyaltyprogram.core.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    ServiceRepository serviceRepository;

    public void writePurchase(DefaultPurchase body) {
        purchaseRepository.save(body);
    }
    public void writeServicePurchase(ServicePurchase service){ serviceRepository.save(service);}

    public ArrayList<DefaultPurchase> getPurchases() {
        return (ArrayList) purchaseRepository.findAll();
    }

    public Optional<DefaultPurchase> getPurchaseByCode(Integer businessId, String type, String code){
        return getPurchases().stream()
                .filter((p)->p.getType().equals(type))
                .filter((p) -> p.getBusinessId().equals(businessId))
                .filter((p)-> p.getCode().equals(code)).findFirst();
    }
}
