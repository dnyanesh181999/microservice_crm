package com.cjc.loanapplication.servicei;

import java.util.List;

import com.cjc.loanapplication.model.Enquiry;

public interface CrmServicei {

	List<Enquiry> getAllEnquiry();

	List<Enquiry> getStatusApproved();

	List<Enquiry> getStatusRejected();

	Enquiry updateEnquiry(Integer enquiryId, Enquiry e);

	List<Enquiry> getStatusPending();

	Enquiry getEnquiryById(Integer enquiryId);

}
