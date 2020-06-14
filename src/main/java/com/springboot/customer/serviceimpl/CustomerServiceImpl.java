package com.springboot.customer.serviceimpl;

import com.springboot.customer.modal.Customer;
import com.springboot.customer.repository.CustomerRepository;
import com.springboot.customer.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer save(Customer customer) {

        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {

        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) throws NotFoundException {
        Customer customer = repository.findById(id).orElse(null);

        if (Objects.isNull(customer))
            throw new NotFoundException("invalid customer id " + id);
        return customer;
    }

    @Override
    public void deleteCustomerId(Long id) throws Exception {
        try {

            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("something wrong here ");
        }
    }

    @Override
    @Transactional
    public Customer updateCustomerId(Customer customer) {
        return repository.save(customer);
    }
}
