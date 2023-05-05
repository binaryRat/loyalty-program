package it.unicam.ids.loyaltyprogram.purchase;

import it.unicam.ids.loyaltyprogram.customer.Customer;
import it.unicam.ids.loyaltyprogram.dbaccess.CustomerRepository;
import it.unicam.ids.loyaltyprogram.dbaccess.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository repository;

    public void writePurchase(DefaultPurchase body) {
        repository.save(body);
    }

    public ArrayList<DefaultPurchase> getPurchases() {
        return (ArrayList) repository.findAll();
    }
}
