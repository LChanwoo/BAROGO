package market;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketAjaxController {
	@Autowired
	@Qualifier("marketservice")
	MarketService service;
	@PostMapping("basket")
	public List<MarketDTO> basket(HttpSession session,MarketDTO dto){
		dto.setId((String)(session.getAttribute("userId")));
		service.insertbasket(dto);
		List<MarketDTO> list;
		if(dto.getId()==null) {
		list = null;
		}else {
		list = service.basketlist(dto.getId());
		}
		
		
		System.out.println(dto.getMarket());
		return list;
	}
	
	@PostMapping("deletebasket")	
	public List<MarketDTO> deletebasket(@RequestParam(value="name[]") String[] name,HttpSession session){
		System.out.println("===삭제할 이름:"+name);
		MarketDTO dto =new MarketDTO();
		dto.setId((String)session.getAttribute("userId"));
		System.out.println(dto.getId());
		for(int i =0 ; i<name.length;i++)
		{
			service.deletebasket(name[i]);
		}
		
		List<MarketDTO> list = service.basketlist(dto.getId());
		
		return list;
	}
	@PostMapping("changeoption")
	public List<MarketDTO> changeoption(MarketDTO dto){
		List<MarketDTO> changelist =  service.marketproduct(dto.market);
		
		return changelist;
	}

	
	
	
	
	
	
	
	
	
	
	
}
