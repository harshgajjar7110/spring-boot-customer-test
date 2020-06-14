package com.springboot.customer.repository;

import com.springboot.customer.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
