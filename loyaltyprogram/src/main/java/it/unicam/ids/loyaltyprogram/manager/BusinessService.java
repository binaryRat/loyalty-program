package it.unicam.ids.loyaltyprogram.manager;


import it.unicam.ids.loyaltyprogram.dbaccess.BusinessRepository;
import it.unicam.ids.loyaltyprogram.dbaccess.ModuleRepository;
import it.unicam.ids.loyaltyprogram.dbaccess.ProgramRepository;
import it.unicam.ids.loyaltyprogram.dbaccess.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProgramRepository programRepository;
    public void writeBusiness(DefaultBusiness business){
        //businessRepository.save(business);

        /*business.getStores().forEach((store) -> storeRepository.save(store));
        business.getPrograms().forEach((program) -> {
            moduleRepository.save(program.getModule());
            programRepository.save(program);
        });
        moduleRepository.save(business.getModule());*/
        businessRepository.save(business);
        System.out.println("Writing business to database :" + business.getModule().getName());
    }

    public ArrayList<DefaultBusiness> getBusinesses() {
        return (ArrayList) businessRepository.findAll();
    }

    public Optional<DefaultBusiness> getBusiness(Integer id) {
        return businessRepository.findById(id);
    }

}
