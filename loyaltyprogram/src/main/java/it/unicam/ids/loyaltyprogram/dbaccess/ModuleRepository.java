package it.unicam.ids.loyaltyprogram.dbaccess;
import it.unicam.ids.loyaltyprogram.manager.InformationModule;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ModuleRepository extends CrudRepository<InformationModule, Integer> {

}