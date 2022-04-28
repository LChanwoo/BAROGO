package hotel;



public interface MessageService {
	public void sendMessage(String toNumber, String randomNumber);
	public void sendReservationMessage(String toNumber,String hotel_name);
}
