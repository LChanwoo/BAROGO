package market;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarketadminController {
//	상품등록

	@Autowired
	@Qualifier("marketservice")
	MarketService service;
	
	@RequestMapping(value="/marketadmin" ,method=RequestMethod.GET)
	public ModelAndView protable(HttpSession session ,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		//setid 
		String id = (String)session.getAttribute("userId");
		List<MarketDTO> list = service.productlist(id);
		mv.addObject("list",list);
		MarketDTO marketadminlist = service.marketadminlist(id);
		
	if(marketadminlist != null) {
				
			mv.setViewName("marketadmin");
		
		}else {
			try {
			
			
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('마켓관리자 회원이아닙니다')</script>");
			 
			out.flush();
			
			}catch (Exception e) {}
			mv.setViewName("/marketceo");
		
		}
		return mv;
	}
	@RequestMapping("/marketmypage")
	public ModelAndView marketadmininsert(HttpServletResponse response,HttpSession session,MarketDTO dto ) throws IOException {
		//address , id , market 인수
		dto.setId((String)(session.getAttribute("userId")));
		System.out.println(dto.getMarket());
		System.out.println(dto.getAddress());
		System.out.println(dto.getId());
		
		
		
		
		service.insertmarketadmin(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		out.println("<script>alert('마켓회원으로 등록되었습니다')</script>");
		 
		out.flush();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage");
		
		return mv;
	}
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
