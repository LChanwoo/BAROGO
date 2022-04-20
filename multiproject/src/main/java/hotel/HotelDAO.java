package hotel;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("hoteldao")
public interface HotelDAO {
	public int postHotel(HotelPostDTO dto); 
	public int postHotelName(HotelPostDTO dto); 
	public int postHotelRoom(HotelRoomDTO dto); 
	public int postHotelPicture(HotelPictureDTO dto); 
	public int selectHotelcount(HotelPostDTO dto); 
	public int updateHotelPicture(HotelPostDTO dto);
	public ArrayList<HotelPostDTO> selectHotelManageList(HotelPostDTO dto); 
	public ArrayList<HotelPostDTO> selectHotelid(HotelPostDTO dto); 
}
