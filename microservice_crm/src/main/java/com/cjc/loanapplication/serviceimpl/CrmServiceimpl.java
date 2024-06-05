package com.cjc.loanapplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.NoApprovedEnquiryFoundException;
import com.cjc.loanapplication.exceptions.NoEnquiryFoundException;
import com.cjc.loanapplication.exceptions.NoEnquiryFoundToUpdateException;
import com.cjc.loanapplication.exceptions.NoPendingEnquiryFoundException;
import com.cjc.loanapplication.exceptions.NoRejectedEnquiryFoundException;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.repository.CrmRepository;
import com.cjc.loanapplication.servicei.CrmServicei;

@Service
public class CrmServiceimpl implements CrmServicei {
	
	@Autowired
	CrmRepository crp;

	@Override
	public List<Enquiry> getAllEnquiry() {
		
		List<Enquiry> list=crp.findAll();
		if(list.isEmpty())
		{
			throw new NoEnquiryFoundException("No enquiry found...!");
		}
		
		return list;
	}

	@Override
	public List<Enquiry> getStatusApproved() {
		List<Enquiry> approved=crp.findAllByRemark("Approved");
		if(!approved.isEmpty()) {
			return approved;
		}
			else
			{
				throw new NoApprovedEnquiryFoundException("No Approved Enquiry Found...!");
			}
			
		}
		
		
	

	@Override
	public List<Enquiry> getStatusRejected() {
		
		List<Enquiry> rejected=crp.findAllByRemark("Rejected");
		
		if(!rejected.isEmpty()) {
			return rejected;
		}
			else
			{
				throw new NoRejectedEnquiryFoundException("No Rejected Enquiry Found...!");
			}
		}
		
	
	@Override
	public List<Enquiry> getStatusPending() {
		List<Enquiry> pending=crp.findAllByRemark("Pending");
		
		if(!pending.isEmpty())
		{
			return pending;
		}
		else
		{
			throw new NoPendingEnquiryFoundException("No Pending Enquiry found");
		}

	}
	

	@Override
	public Enquiry updateEnquiry(Integer enquiryId, Enquiry e) {
		
		Optional<Enquiry> op=crp.findById(enquiryId);
		
		if(op.isPresent())
		{
			Enquiry enq=op.get();
			
			if(e.getRemark()!=null)
			{
				enq.setRemark("FTOE");
			}
			return crp.save(enq);
		}
		else
		{
			throw new NoEnquiryFoundToUpdateException("No Enquiry found to update...!");
		}
	}

	
	

}
