package hotel;

public class hotelmanagelistDTO {
	String hotelName,pic_url,contents,location;



	@Override
	public String toString() {
		return "hotelmanagelistDTO [hotelName=" + hotelName + ", pic_url=" + pic_url + ", contents=" + contents
				+ ", location=" + location + "]";
	}

	public hotelmanagelistDTO() {}

	public hotelmanagelistDTO(String hotelName, String pic_url, String contents, String location) {
		this.hotelName = hotelName;
		this.pic_url = pic_url;
		this.contents = contents;
		this.location = location;
	}



	public String getHotelname() {
		return hotelName;
	}

	public void setHotelname(String hotelname) {
		this.hotelName = hotelname;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
