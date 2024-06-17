package com.cjc.loanapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cjc.loanapplication.model.Enquiry;

public interface CrmRepository extends JpaRepository<Enquiry, Integer> {
	
	 public List<Enquiry> findAllByRemark(String remarkS);

	public Enquiry findByEnquiryName(String enquiryName);

}
