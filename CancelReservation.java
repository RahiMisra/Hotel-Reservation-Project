import java.sql.Connection;

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
