package edu.multi.kdigital;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hotel.hotelmanagelistDTO;

@Controller
public class hotelController {

	@RequestMapping("/Hotel")
	public String main(){ 
		return "Hotel"; 
	}
	@RequestMapping("/hotel")
	public String main2(){ 
		return "Hotel"; 
	}
	

	@RequestMapping(value="/hotel/manage", method= RequestMethod.GET)
	public ModelAndView hotelmanage(){ 
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("/hotel/manage");
		return mv; 
		
	}	
	@ResponseBody
	@RequestMapping(value="/hotel/manage", method= RequestMethod.POST)
	public ArrayList< hotelmanagelistDTO> hotelmanagelist(String str){ 
		System.out.println(str);
		ArrayList< hotelmanagelistDTO> alist= new ArrayList< hotelmanagelistDTO>();
		alist.add(new hotelmanagelistDTO("호텔1", "/images/hotel111.jpg", "침대1개","서울"));
		alist.add(new hotelmanagelistDTO("호텔3", "/images/hotel111.jpg", "침대2개","경기"));
		alist.add(new hotelmanagelistDTO("호텔4", "/images/hotel111.jpg", "침대4개","부산"));
		return alist; 
		
	}	
	@RequestMapping("/hotel/manage/add")
	public String add(){ 
		return "/hotel/manage/add"; 
	}
	@RequestMapping("/hotel/manage/jusoPopup")
	public String jusoPopup(){ 
		return "jusoPopup"; 
	}



}


