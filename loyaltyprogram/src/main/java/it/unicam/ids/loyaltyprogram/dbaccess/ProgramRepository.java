package it.unicam.ids.loyaltyprogram.dbaccess;
import it.unicam.ids.loyaltyprogram.manager.DefaultBusiness;
import it.unicam.ids.loyaltyprogram.manager.LoyaltyProgram;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProgramRepository extends CrudRepository<LoyaltyProgram, Integer> {

}