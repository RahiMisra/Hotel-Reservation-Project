import java.sql.Connection;

public class updateReservation extends DatabaseMethods {
	public void updateHotelReservation(Connection con, Reservation tempReservation, int room, String date, int price) {
		updateReservationRoom(con, tempReservation.getRoom(), tempReservation.getDate(), room);
		updateReservationDate(con, tempReservation.getRoom(), tempReservation.getDate(), date);
		updateReservationPrice(con, tempReservation.getRoom(), tempReservation.getDate(), price);
		
		tempReservation.setRoom(room);
		tempReservation.setDate(date);
		tempReservation.setPrice(price);
		
	}
}
