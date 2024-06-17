package com.cjc.loanapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.model.Customer;
import com.cjc.loanapplication.repository.CustomerRepository;
import com.cjc.loanapplication.servicei.CustomerServiceI;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	
	@Autowired
	CustomerRepository cr;

	@Override
	public Customer saveCustomer(Customer cust) {
		cust.setStatus("Pending");
		return cr.save(cust);
		
	}
}
