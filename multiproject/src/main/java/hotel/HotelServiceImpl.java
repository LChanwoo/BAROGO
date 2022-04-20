package hotel;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hotelservice")
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDAO dao;

	
	public int postHotel(HotelPostDTO dto) {
		return dao.postHotel(dto);
	}
	public int postHotelName(HotelPostDTO dto) throws Exception {
		return dao.postHotelName(dto);
	}
	public int postHotelRoom(HotelRoomDTO dto){
		return dao.postHotelRoom(dto);
	}
	public int postHotelPicture(HotelPictureDTO dto){
		return dao.postHotelPicture(dto);
	}
	public int selectHotelcount(HotelPostDTO dto){
		return dao.selectHotelcount(dto);
	}
	public int updateHotelPicture(HotelPostDTO dto){
		return dao.updateHotelPicture(dto);
	}
	public ArrayList<HotelPostDTO> selectHotelManageList(HotelPostDTO dto){
		return dao.selectHotelManageList(dto);
	}
	public ArrayList<HotelPostDTO> selectHotelid(HotelPostDTO dto){
		return dao.selectHotelid(dto);
	}
}
