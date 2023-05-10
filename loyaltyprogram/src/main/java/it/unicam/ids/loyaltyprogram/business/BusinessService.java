package it.unicam.ids.loyaltyprogram.business;

import it.unicam.ids.loyaltyprogram.core.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;

    public void writeBusiness(DefaultBusiness business){
        businessRepository.save(business);
        System.out.println("Writing business to database :" + business.getModule().getName());
    }

    public ArrayList<DefaultBusiness> getBusinesses() {
        return (ArrayList) businessRepository.findAll();
    }

    public Optional<DefaultBusiness> getBusiness(Integer id) {
        return businessRepository.findById(id);
    }
    public DefaultProduct getProductByCode(Integer businessId, String code){
        DefaultBusiness business = getBusiness(businessId).get();
        List<DefaultProduct> result = business.getPrograms().stream()
                .flatMap((program) -> program.getProducts().stream())
                .filter((product) -> product.getCode().equals(code))
                .toList();
        if (result.size() < 1) return null;
        if (result.size() > 1) throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "More than one product with specific code"
        );
        return result.get(0);
    }

}
