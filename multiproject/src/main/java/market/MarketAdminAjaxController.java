package market;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketAdminAjaxController {
	
	
	@Autowired
	@Qualifier("marketservice")
	MarketService service;
	
	
	
	@PostMapping("ajaxtable2")
	public List<MarketDTO> creattable(HttpSession session,MarketDTO dto) {
		// 연계데이터부분
		dto.setId((String)session.getAttribute("userId"));//id 
		String market = service.market(dto.getId());
		dto.setMarket(market);
//		System.out.println(market);
//		System.out.println(dto.getId());
//		System.out.println(dto.getName());
//		System.out.println(dto.getPrice());
//		System.out.println(dto.getNum());
		
		try {
		String originfilename =dto.img.getOriginalFilename();
		String beforefilename =originfilename.substring(0, originfilename.indexOf("."));
		String afterfilename =originfilename.substring(originfilename.indexOf("."));
		String imgname1 = beforefilename+UUID.randomUUID().toString()+afterfilename;
		dto.setImgname(imgname1);
		
		String savePath="/usr/mydir/upload/";
		File serverfile = new File(savePath+imgname1);
		dto.getImg().transferTo(serverfile);
		service.insertproduct(dto);
		}catch(Exception e){
			
		}
		List<MarketDTO> list = service.productlist(dto.id);
		System.out.println(list.size());
		System.out.println(dto.getImgname());
		return list;
	}
	@PostMapping("ajaxdelete")
	public /*List<MarketDTO>*/MarketDTO deletetable(String name) {
		service.deletepro(name);
//		List<MarketDTO> list = service.productlist("aaaa");
		
		
		return new MarketDTO();
				}
	
	
	@PostMapping("updateinfo")
	public MarketDTO updateinfo(HttpSession session , MarketDTO dto) {
		
		dto.setId((String)session.getAttribute("userId")); 
		MarketDTO dto1 =  service.updateinfo(dto);
	
		
		
		return dto1;
	}
	
	@PostMapping("ajaxupdate")
	public MarketDTO ajaxupdate(HttpSession session,MarketDTO dto){
		// 연계데이터부분
		dto.setId((String)session.getAttribute("userId"));//id 
		
		String market = service.market(dto.getId());
		
		dto.setMarket(market);
		
		
		try {
		String originfilename =dto.img.getOriginalFilename();
		String beforefilename =originfilename.substring(0, originfilename.indexOf("."));
		String afterfilename =originfilename.substring(originfilename.indexOf("."));
		String imgname1 = beforefilename+UUID.randomUUID().toString()+afterfilename;
		dto.setImgname(imgname1);
		
		String savePath = "/usr/mydir/upload/";
		File serverfile = new File(savePath+imgname1);
		dto.getImg().transferTo(serverfile);
		service.updatemember(dto);
		}catch(Exception e){
			
		}
		System.out.println("아이디:"+dto.getId());
		System.out.println("마켓:"+dto.getMarket());
		System.out.println("이름:"+dto.getName());
		System.out.println("가격:"+dto.getPrice());
		System.out.println("수량:"+dto.getNum());
		System.out.println("설명:"+dto.getExplain1());
		System.out.println("이미지이름:"+dto.getImgname());
		return new MarketDTO();
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
