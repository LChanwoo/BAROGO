package hotel;


import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;



@Controller
public class hotelController {
	
	@Autowired
	@Qualifier("hotelservice")
	HotelService hotelservice;
	
	@Autowired
	@Qualifier("mservice")
	MessageService mservice;
	 
	@Autowired
	@Qualifier("mapservice")
	NaverMapService mapservice;
	
	@RequestMapping("/Hotel")
	public String main(){ 
		return "Hotel"; 
	}
	@RequestMapping("/hotel")
	public String main2(){ 
		return "Hotel"; 
	}
	@RequestMapping("/hotel/")
	public ModelAndView hoteldetail(String id,HttpSession session, HttpServletResponse response){ 
		hoteldetailidcheker(response, id);
		ModelAndView mv= new ModelAndView();
		JsonNode address= mapservice.get("제주특별자치도 제주시 노연로 12");
		String x=address.get("addresses").get(0).get("x").toPrettyString();
		String y=address.get("addresses").get(0).get("y").toPrettyString();
		x = x.replaceAll("\"", "");
		y = y.replaceAll("\"", "");
	
		mv.addObject("title", "A 호텔"); 
		mv.addObject("x", x); 
		mv.addObject("y", y); 
		mv.setViewName("/hotel/hotels");
		return mv; 
	
	}
	@ResponseBody
	@RequestMapping(value="/hotel/getAddress",method = RequestMethod.POST )
	public JsonNode hoteldetail2(){ 
		JsonNode address= mapservice.get("서울시 송파구 방이동 159-13");
		
		return address; 
	}
	

	@RequestMapping(value="/hotel/manage", method= RequestMethod.GET)
	public ModelAndView hotelmanage( 
			@RequestParam(value = "page", required = false, defaultValue = "1")int page,HttpSession session, HttpServletResponse response ){
		logincheker(session, response);
		ModelAndView mv= new ModelAndView(); 		
		String loginid = (String)session.getAttribute("loginid");
		HotelPostDTO dto= new HotelPostDTO();
		dto.setBusiness_id(loginid);
		dto.setPage(page);
		ArrayList<HotelPostDTO> list = hotelservice.selectHotelManageList(dto);

		mv.addObject("list", list);
		mv.setViewName("/hotel/manage");
		return mv; 
		
	}	
	
	@ResponseBody
	@RequestMapping(value="/hotel/manage", method= RequestMethod.POST)
	public ArrayList< hotelmanagelistDTO> hotelmanagelist(HttpSession session, HotelPostDTO dto){ 
		System.out.println("hotel/manage  -  post요청");
		String loginid = (String)session.getAttribute("loginid");
		dto.setBusiness_id(loginid);
		ArrayList<HotelPostDTO> hpdtos=hotelservice.selectHotelManageList(dto);
		ArrayList<hotelmanagelistDTO> hmdtos= new ArrayList<hotelmanagelistDTO>();
		for (int i = 0; i < hpdtos.size(); i++) {
			String hotelName=hpdtos.get(i).getHotel_name();
			String pic_url=hpdtos.get(i).getHotel_picture();
			System.out.println(pic_url);
			String contents=hpdtos.get(i).getHotel_address1()+" "+hpdtos.get(i).getHotel_address2();
			String location=contents;
			hotelmanagelistDTO hmdto= new hotelmanagelistDTO(hotelName, pic_url, contents, location);
			hmdtos.add(hmdto);
		}
		return hmdtos; 
		
	}	
	@RequestMapping("/hotel/manage/post")
	public String add(HttpSession session, HttpServletResponse response){ 
		return "/hotel/manage/post"; 
	}
	
	@ResponseBody
	@RequestMapping(value="/hotel/manage/post", method=RequestMethod.POST)	
	public String post(HotelPostDTO dto, HttpSession session){
		System.out.println(dto.toString());
		String loginid= (String)session.getAttribute("loginid");
		System.out.println(loginid);
		dto.setBusiness_id(loginid);
		int result=0;
		try {
			result=hotelservice.postHotel(dto);
			ArrayList<HotelPostDTO>  x=hotelservice.selectHotelid(dto);
			System.out.println(x.get(0).getHotel_id());
			System.out.println(dto.getHotel_room());
			String hotel_id =x.get(0).getHotel_id();
			JSONArray jarr = new JSONArray(dto.getHotel_room());
			System.out.println(jarr.length());
			for (int i = 0; i <jarr.length(); i++) {
				JSONObject tmp=(JSONObject)jarr.get(i);
				String room_name = (String)tmp.get("room_name");
				String room_bed_size = (String)tmp.get("room_bed_size");
				int room_bed_qty = Integer.parseInt( (String)tmp.get("room_bed_qty"));
				int room_price = Integer.parseInt( (String)tmp.get("room_price"));
				String room_etc = (String)tmp.get("room_etc");
				HotelRoomDTO hrdto = new HotelRoomDTO(hotel_id,room_name, room_bed_size, room_bed_qty, room_price, room_etc);
				int hrres = hotelservice.postHotelRoom(hrdto);
				System.out.println(hrres);
			}
			JSONArray picarr = new JSONArray(dto.getHotel_picture());
			for (int i = 0; i <picarr.length(); i++) {
				JSONObject tmp=(JSONObject)picarr.get(i);
				String pathtmp = (String)tmp.get("path");
				System.out.println(pathtmp);
				String pathtmp2 = pathtmp.substring(2, pathtmp.length());
				System.out.println(pathtmp2);
				String path = pathtmp2.replaceAll("\\\\","/");
				System.out.println(path);
				HotelPictureDTO hpdto= new HotelPictureDTO(hotel_id,path);
				int hpres = hotelservice.postHotelPicture(hpdto);
				System.out.println(hpres);
			}
			JSONObject tmp=(JSONObject)picarr.get(picarr.length()-1);
			String pathtmp = (String)tmp.get("path");
			String pathtmp2 = pathtmp.substring(2, pathtmp.length());
			String path = pathtmp2.replaceAll("\\\\","/");
			System.out.println(path);
			dto.setHotel_picture(path);
			dto.setHotel_id(hotel_id);
			System.out.println(dto.getHotel_id());
			System.out.println(dto.getHotel_picture());
			int picture_update=hotelservice.updateHotelPicture(dto);
			System.out.println(picture_update);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result+""; 

	}
	
	@RequestMapping("/hotel/manage/edit")
	public String edit(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		return "/hotel/manage/post"; 
	}
	@RequestMapping("/hotel/manage/delete")
	public String delete(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		return "/hotel/manage/delete"; 
	}
	@RequestMapping("/hotel/manage/agree")
	public String agree(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		return "/hotel/manage/agree"; 
	}
	@RequestMapping("/hotel/manage/joinceo")
	public String joinceo1(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		return "/hotel/manage/joinceo"; 
	}
	@RequestMapping("/hotel/manage/jusoPopup")
	public String jusoPopup(){ 
		return "jusoPopup"; 
	}

	
	 @ResponseBody
	 @RequestMapping(value="/hotel/manage/phonecert", method= RequestMethod.POST)
	 public MessageDTO sendmessage(MessageDTO dto){ 
		 MessageDTO result = new MessageDTO();
		 try {
		 System.out.println(dto.getPhone_number()); 
		 DecimalFormat df= new DecimalFormat("0000");
		 String randomNumber = df.format((int)(Math.random()*9999));
			/* mservice.sendMessage(dto.getPhone_number(), randomNumber); */
		 	result.setRandomNumber(randomNumber);
		 }catch (Exception e) {
			 e.printStackTrace(); 
		 } 
		 return result;
	 }


	@RequestMapping("/hotellogin")
	public String sss2(HttpSession session){ 
		session.setMaxInactiveInterval(1800);
		session.setAttribute("loginid", "example"  );
		return "hotellogin"; 
	}
	

	private void logincheker(HttpSession session, HttpServletResponse response) {
		if(session.getAttribute("loginid")==null) {
			try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.'); location.href='/main/';</script>");
			out.flush();
			}catch(Exception e){}
			
		}
	}
	private void hoteldetailidcheker(HttpServletResponse response, String id) {
		if(id==null) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잘못된 접근입니다.'); location.href='/main/';</script>");
				out.flush();
			}catch(Exception e){}
			
		}
	}
	@ResponseBody
	@RequestMapping(value="/hotel/manage/getcount", method= RequestMethod.POST)
	public String hotelmanagelist(HttpSession session){ 
		System.out.println("hotel/manage/getcount  -  post요청");
		String loginid = (String)session.getAttribute("loginid");
		HotelPostDTO dto = new HotelPostDTO();
		dto.setBusiness_id(loginid);
		int count = hotelservice.selectHotelcount(dto);

			
		return  "{\"count\":"+count+"}"; 
		
	}	

}


