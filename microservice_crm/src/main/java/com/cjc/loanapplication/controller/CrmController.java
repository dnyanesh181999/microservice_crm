package com.cjc.loanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.CrmServicei;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("CRM")
public class CrmController {

	@Autowired
	CrmServicei csi;
	
	@GetMapping("/getEnquiry")
	public ResponseEntity<List<Enquiry>> getEnquiry()
	{
		List<Enquiry> list=csi.getAllEnquiry();
		log.info("Getting all Enquiries");
		
		return new ResponseEntity<List<Enquiry>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/getStatusApproved")
	public ResponseEntity<List<Enquiry>> getStatusApproved()
	{
		List<Enquiry> approved=csi.getStatusApproved();
		log.info("Getting Approved Enquiries");
		
		return new ResponseEntity<List<Enquiry>>(approved,HttpStatus.OK);
	}
	
	
	@GetMapping("/getStatusRejected")
	public ResponseEntity<List<Enquiry>> getStatusRejected()
	{
		List<Enquiry> rejected=csi.getStatusRejected();
		log.info("Getting Rejected Enquiries");
		
		return new ResponseEntity<List<Enquiry>>(rejected,HttpStatus.OK);
	}
	
	
	@GetMapping("/getStatusPending")
	public ResponseEntity<List<Enquiry>> getStatusPending()
	{
		List<Enquiry> pending=csi.getStatusPending();
		log.info("Getting Pending Enquiries");
		
		return new ResponseEntity<List<Enquiry>>(pending,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updateEnquiry/{enquiryId}")
	public ResponseEntity<Enquiry> updateEnquiry(@PathVariable Integer enquiryId,@RequestBody Enquiry e)
	{
		Enquiry eq=csi.updateEnquiry(enquiryId,e);
		log.info("Updating Enquiry to FTOE");
		
		return new ResponseEntity<Enquiry>(eq,HttpStatus.OK);
	}
	
	@GetMapping("/getEnquiryById/{enquiryId}")
	public ResponseEntity<Enquiry> getEnquiryById(@PathVariable Integer enquiryId)
	{
		Enquiry enq=csi.getEnquiryById(enquiryId);
		
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updateEnquiryForLoan/{enquiryId}")
	public ResponseEntity<Enquiry> updateEnquiryForLoan(@PathVariable Integer enquiryId)
	{
		Enquiry eq=csi.updateEnquiryForLoan(enquiryId);
		log.info("Updating Enquiry to ApplyForLoan");
		
		return new ResponseEntity<Enquiry>(eq,HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
