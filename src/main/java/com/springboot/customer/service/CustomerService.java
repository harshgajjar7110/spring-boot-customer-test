package com.springboot.customer.service;

import com.springboot.customer.modal.Customer;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id) throws NotFoundException;

    void deleteCustomerId(Long id) throws Exception;

    Customer updateCustomerId(Customer id) throws NotFoundException;


}
