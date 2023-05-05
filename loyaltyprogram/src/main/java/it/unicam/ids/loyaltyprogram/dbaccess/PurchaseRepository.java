package it.unicam.ids.loyaltyprogram.dbaccess;
import it.unicam.ids.loyaltyprogram.purchase.DefaultPurchase;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PurchaseRepository extends CrudRepository<DefaultPurchase, Integer> {

}