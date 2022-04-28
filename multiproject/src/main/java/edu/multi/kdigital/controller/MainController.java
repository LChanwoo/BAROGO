package edu.multi.kdigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home(Model model) {
		return "/main";
	}
	@RequestMapping("/main")
	public String home2(Model model) {
		return "/main";
	}
}