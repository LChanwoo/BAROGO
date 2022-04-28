package edu.multi.kdigital.service;

import java.util.List;

import edu.multi.kdigital.dto.PaymentDto;

public interface PaymentService {
	
	public void paymentinfo(PaymentDto dto);
	
	 public List<PaymentDto> paymentList(PaymentDto dto);
	

}
