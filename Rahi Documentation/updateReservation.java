import java.sql.Connection;
/**
 * updateHotelReservation edits the room, date, and price columns on the Reservations table in the online database and then changes them locally
 * @param connection
 * @param reservation
 * @param room number
 * @param date
 * @param price
 * @author Rahi Misra
 *4/15/23
 */
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
