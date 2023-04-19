import java.sql.Connection;
/**
 * cancelOrderReservation deletes the reservation from the database, then deletes it locally
 * @param connection
 * @param reservation
 * @author Rahi Misra
 * 4/17/23
 */
class CancelReservation extends DatabaseMethods {
	public void cancelOrderReservation(Connection con, Reservation tempReservation) {
		//delete the reservation from the database
		deleteReservation(con, tempReservation.getRoom(), tempReservation.getDate());
		
		//delete the local reservation
		tempReservation.setDate(null);
		tempReservation.setPrice(0);
		tempReservation.setRoom(0);
		tempReservation.setUsername(null);
	}
}
