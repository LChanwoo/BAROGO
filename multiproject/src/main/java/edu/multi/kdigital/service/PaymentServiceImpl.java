package edu.multi.kdigital.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import edu.multi.kdigital.dto.PaymentDto;
import edu.multi.kdigital.dao.PaymentMapper;
import edu.multi.kdigital.repository.MemberRepository;

@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService {
	@Inject
	PaymentMapper pservice;
	
	public MemberRepository memberRepository;
	
	
	@Override
	public void paymentinfo(PaymentDto dto) {
		dto.setProname(dto.getProname());
		pservice.paymentinfo(dto);
		}
	
	 @Override
	    public List<PaymentDto> paymentList(PaymentDto dto) {
	        return pservice.paymentList(dto);

        }
	 
}


