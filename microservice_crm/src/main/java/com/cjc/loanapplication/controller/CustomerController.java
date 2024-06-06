package com.cjc.loanapplication.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.loanapplication.model.AllPersonalDocs;
import com.cjc.loanapplication.model.Customer;
import com.cjc.loanapplication.model.Mortgage;
import com.cjc.loanapplication.model.Profession;
import com.cjc.loanapplication.servicei.CustomerServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	CustomerServiceI csi;
	
	@PostMapping(value = "/saveCustomer", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Customer> saveCustomer(@RequestPart("addressProof") MultipartFile adp,
												@RequestPart("panCard") MultipartFile pc,
												@RequestPart("aadharCard") MultipartFile ad,
												@RequestPart("incomeTaxReturn") MultipartFile itr,
												@RequestPart("photo") MultipartFile ph,
												@RequestPart("signature") MultipartFile sign,
												@RequestPart("thumb") MultipartFile thumb,
												@RequestPart("bankCheque") MultipartFile bc,
												@RequestPart("bankStatement") MultipartFile bs,
												@RequestPart("propertyProof") MultipartFile pProof,
												@RequestPart("propertyInsurance") MultipartFile pInsurance,
												@RequestPart("professionalSalarySlips") MultipartFile ps,
												@RequestPart("JsonData") String json) throws IOException
	{
		
		ObjectMapper om=new ObjectMapper();
		
		Customer cust=om.readValue(json, Customer.class);
		
		AllPersonalDocs apd = new AllPersonalDocs();
		apd.setAddressProof(adp.getBytes());
		apd.setPanCard(pc.getBytes());
		apd.setAadharCard(ad.getBytes());
		apd.setIncomeTaxReturn(itr.getBytes());
		apd.setPhoto(ph.getBytes());
		apd.setSignature(sign.getBytes());
		apd.setThumb(thumb.getBytes());
		apd.setBankCheque(bc.getBytes());
		apd.setBankStatement(bs.getBytes());
		apd.setPropertyProof(pProof.getBytes());
		apd.setPropertyInsurance(pInsurance.getBytes());
		apd.setProfessionalSalarySlips(ps.getBytes());
		cust.setAllPersonalDocs(apd);
	
		
		Customer c=csi.saveCustomer(cust);
		log.info("Loan Application save sucessfully");
		return new ResponseEntity<Customer>(c,HttpStatus.CREATED);
		
	}
	
	
	

}
