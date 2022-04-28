package edu.multi.kdigital.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import edu.multi.kdigital.dto.PaymentDto;
import edu.multi.kdigital.service.PaymentService;


@Controller
public class PaymentListController {
	
	@Inject
	PaymentService pservice;
	
	   @RequestMapping(value="/paymentlist.do", method=RequestMethod.GET)
	    public String paymentList(PaymentDto dto, Model model) {	        
		   System.out.println(dto.getUserId()); 
		   List<PaymentDto> list = pservice.paymentList(dto);
	        model.addAttribute("list", list);
	        
	        return "/paymentlist";
	    }
}