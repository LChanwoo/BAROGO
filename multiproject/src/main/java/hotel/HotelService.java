package hotel;

import java.util.ArrayList;

public interface HotelService {
	public int postHotel(HotelPostDTO dto); 
	public int postHotelName(HotelPostDTO dto)throws Exception; 
	public int postHotelRoom(HotelRoomDTO dto);
	public int postHotelPicture(HotelPictureDTO dto);
	public int updateHotelPicture(HotelPostDTO dto);
	public int selectHotelcount(HotelPostDTO dto);
	public ArrayList<HotelPostDTO> selectHotelManageList(HotelPostDTO dto); 
	public ArrayList<HotelPostDTO> selectHotelid(HotelPostDTO dto);
}
