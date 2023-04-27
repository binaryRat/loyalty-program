package it.unicam.ids.loyaltyprogram;

import it.unicam.ids.loyaltyprogram.manager.Business;
import it.unicam.ids.loyaltyprogram.manager.DefaultBusiness;
import it.unicam.ids.loyaltyprogram.manager.Product;

import java.util.List;
import java.util.Optional;

public class BusinessesBrowser implements Browser{
    public static Optional<Product> getProductByCode(String code){
        List<DefaultBusiness> businesses = DBReader.getBusinesses();
        Optional<Product> result = businesses.stream()
                .flatMap((business) -> business.getPrograms().stream())
                .flatMap((program) -> program.getProducts().stream())
                .filter(product -> product.getCode() == code)
                .findAny();
        return result;
    }
}