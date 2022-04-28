package market;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarketController {
	
@Autowired
@Qualifier("marketservice")
MarketService service;

@GetMapping("/market")
public ModelAndView market(HttpSession session,MarketDTO dto){
	String marketname = dto.market;
	dto.setId((String)(session.getAttribute("userId")));//session으로변경
	List<MarketDTO> marketprolist =  service.marketproduct(dto.market);
	//get방식으로 전송된 market
	List<MarketDTO> basketlist = service.basketlist(dto.id);//회원아이디로 조회
	List<MarketDTO> marketlistrepeat = service.marketlist();
	ArrayList<MarketDTO> marketlist = new ArrayList<MarketDTO>();

	marketlist.add(marketlistrepeat.get(0));
for(int i =1 ; i<marketlistrepeat.size();i++) {

if(!marketlistrepeat.get(i).market.toString().equals( marketlistrepeat.get(i-1).market.toString())) {
	//1마켓이랑 0 마켓이랑 비교 후 같지않으면 marketlist에 추가
	
	marketlist.add(marketlistrepeat.get(i));//같으면추가됨 
		
		}
	}
	
	
	
	
	ModelAndView mv= new ModelAndView();
	mv.addObject("marketprolist",marketprolist);
	mv.addObject("basketlist",basketlist);
	mv.addObject("marketlist",marketlist);
	mv.addObject("marketname",marketname);
	mv.setViewName("market");
	
	
	
	return mv; 
	}

	@GetMapping("/payment")
	public ModelAndView payment(HttpSession session,MarketDTO dto) {
		dto.setId((String)session.getAttribute("userId"));
		
		ModelAndView mv= new ModelAndView();
		System.out.println(dto.getId()+"가격:" + dto.getPrice());
		mv.addObject("paydto",dto);
		mv.setViewName("payment");
		return mv;
	}



}


