package it.unicam.ids.loyaltyprogram.manager;

import java.util.List;

public interface Program extends Parameterized{
     List<Product> getProducts();

     void addProducts(List<Product> products);

     void addService(Service service);
}
