package com.cjc.loanapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.loanapplication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
