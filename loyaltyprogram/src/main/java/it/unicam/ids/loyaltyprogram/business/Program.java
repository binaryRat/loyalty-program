package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.core.Module;

import java.util.List;

public interface Program<P extends Product, S extends Service, M extends Module> extends Parameterized<M>{
     List<P> getProducts();

     void addProducts(List<P> products);

     void addService(S service);
}
