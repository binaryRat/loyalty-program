package it.unicam.ids.loyaltyprogram.purchase;

import it.unicam.ids.loyaltyprogram.customer.Customer;
import it.unicam.ids.loyaltyprogram.manager.BusinessService;
import it.unicam.ids.loyaltyprogram.manager.DefaultBusiness;
import it.unicam.ids.loyaltyprogram.manager.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping(path = "/api/purchases")
public class PurchaseRestController {
    @Autowired
    private PurchaseService service;
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public String addPurchase(@RequestBody DefaultPurchase body){
        service.writePurchase(body);
        return "Purchase created";
    }
    @GetMapping(value = "", produces = "application/json")
    public List<DefaultPurchase> listBusinesses(){
        ArrayList<DefaultPurchase> purchases = service.getPurchases();
        return purchases;
    }
    @PostMapping(value = "/collect", consumes = "application/json", produces = "application/json")
    public String collectPurchase(@RequestBody Map<String, String> body){

        return "Purchase created";
    }
}
