package it.unicam.ids.loyaltyprogram.customer;

import it.unicam.ids.loyaltyprogram.dbaccess.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Optional<Customer> getCustomer(Integer id) {
        return customerRepository.findById(id);
    }

    public void writeCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
