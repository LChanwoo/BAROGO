package edu.multi.kdigital.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import edu.multi.kdigital.dto.PaymentDto;

@Mapper
@Repository("payment")
public interface PaymentMapper {


	public void paymentinfo(PaymentDto dto);
	
	 public List<PaymentDto> paymentList(PaymentDto dto);


		
}