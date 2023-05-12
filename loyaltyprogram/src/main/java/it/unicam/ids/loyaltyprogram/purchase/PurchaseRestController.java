package it.unicam.ids.loyaltyprogram.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/purchases")
public class PurchaseRestController {
    @Autowired
    private PurchaseService service;
    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public DefaultPurchase addPurchase(@RequestBody DefaultPurchase body){
        service.writePurchase(body);
        return body;
    }
    @GetMapping(value = "", produces = "application/json")
    public List<DefaultPurchase> listPurchases(){
        ArrayList<DefaultPurchase> purchases = service.getPurchases();
        return purchases;
    }
    @GetMapping(value = "/{uuid}", produces = "application/json")
    public DefaultPurchase getPurchase(@PathVariable String uuid){
        ArrayList<DefaultPurchase> purchases = service.getPurchases();
        DefaultPurchase purchase = purchases.stream().filter((p)->p.getCode().equals(uuid)).findFirst().get();
        return purchase;
    }
    @PostMapping(value = "/{uuid}/consume", produces = "application/json")
    public DefaultPurchase consumePurchase(@PathVariable String uuid){
        ArrayList<DefaultPurchase> purchases = service.getPurchases();
        DefaultPurchase purchase = purchases.stream().filter((p)->p.getCode().equals(uuid)).findFirst().get();
        purchase.consume();
        service.writePurchase(purchase);
        return purchase;
    }

}
