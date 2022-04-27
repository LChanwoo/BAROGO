package edu.multi.kdigital.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.multi.kdigital.dto.PaymentDto;
import edu.multi.kdigital.service.PaymentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {

	@Inject
	PaymentService pservice;
	
	@RequestMapping(value="/helloSpring.sp", method=RequestMethod.POST)

    public String helloSpingPost(PaymentDto pay ,Model model){

           /*

            * 파라미터로 들어온 spring객체에 폼에서 전송된 데이터가 담겨있다.

           */

           String proname = pay.getProname();

           model.addAttribute("message", proname);

           return "/WEB-INF/view/helloSpring.jsp";
}
}