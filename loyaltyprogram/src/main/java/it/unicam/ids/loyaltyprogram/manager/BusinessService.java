package it.unicam.ids.loyaltyprogram.manager;


import it.unicam.ids.loyaltyprogram.dbaccess.BusinessRepository;
import it.unicam.ids.loyaltyprogram.dbaccess.ModuleRepository;
import it.unicam.ids.loyaltyprogram.dbaccess.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private StoreRepository storeRepository;
    public void writeBusiness(DefaultBusiness business){
        //businessRepository.save(business);
        moduleRepository.save(business.getData());
        business.getStores().forEach((store) -> storeRepository.save(store));
        businessRepository.save(business);
        System.out.println("Writing business to database :" + business.getData().getName());
    }

    public void writeProgram(String business, Program program) {
        //System.out.println("Writing program to database :" + program.getData().getName() + " for business :"+business);
    }
}
