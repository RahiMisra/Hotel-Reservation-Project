import java.time.LocalDate;
import java.util.Random;

// Make sure multiple reservations can be done with one account

public class Reservation {
	/**
	 * 
	 * The Reservation class represents a reservation made by a guest for a room in
	 * a hotel. It contains information such as the check-in and check-out dates,
	 * the number of nights reserved, the number of guests, the total price of the
	 * reservation, and the confirmation number. The room selected for the
	 * reservation is also stored in this class. This class allows for multiple
	 * reservations to be made with one account. / public class Reservation { /* The
	 * check-in date for the reservation.
	 */
	private LocalDate checkInDate;
	/**
	 * The check-out date for the reservation.
	 */
	private LocalDate checkOutDate;
	/**
	 * The number of nights reserved for the reservation.
	 */
	private int nightsReserved;
	/**
	 * The number of guests for the reservation.
	 */
	private int guests;
	/**
	 * The total price of the reservation.
	 */
	private int totalPrice;
	/**
	 * The confirmation number for the reservation.
	 */
	private int confirmationNumber;
	/**
	 * The room number selected for the reservation.
	 */
	private int roomNumber;
	/**
	 * The room selected for the reservation.
	 */
	private Room reservedRoom = new Room(roomNumber);

	/**
	 * Constructs a new Reservation object with the given check-in date, check-out
	 * date,
	 * 
	 * number of guests, and room number.
	 * 
	 * @param checkInDate  the check-in date for the reservation
	 * 
	 * @param checkOutDate the check-out date for the reservation
	 * 
	 * @param guests       the number of guests for the reservation
	 * 
	 * @param roomNumber   the room number selected for the reservation
	 */
	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, int guests, int roomNumber) {
		this.checkInDate = checkInDate; // stored as (yyyy, mm, dd), but can be (yyyy, m, d)
		this.checkOutDate = checkOutDate;
		this.nightsReserved = (int) checkInDate.until(checkOutDate).getDays();
		this.guests = guests;
		this.roomNumber = roomNumber;
		this.totalPrice = calculateTotalPrice();
		this.confirmationNumber = generateConfirmationNumber();

		// reservedRoom.setOccupied(true); // once order is completed, done in GUI if
		// all fields are inputted properly
	}

	/**
	 * Calculates the total price of the reservation based on the room's price per
	 * night and the number of nights reserved.
	 * 
	 * @return the total price of the reservation
	 */
	private int calculateTotalPrice() {
		totalPrice = reservedRoom.getPricePerNight() * nightsReserved;
		return totalPrice;
	}

	/**
	 * Generates a random 9-digit confirmation number for the reservation.
	 * 
	 * @return the confirmation number for the reservation
	 */
	private int generateConfirmationNumber() {
		Random random = new Random();
		confirmationNumber = random.nextInt(999999999 - 100000000 + 1) + 100000000;
		return confirmationNumber;
	}

	/**
	 * Returns the check-in date for the reservation.
	 * 
	 * @return the check-in date for the reservation
	 */
	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	/**
	 * Returns the check-out date for the reservation.
	 * 
	 * @return the check-out date for the reservation
	 */
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * This method returns the number of nights reserved for the reservation.
	 *
	 * @return an integer value representing the number of nights reserved
	 */
	public int getNightsReserved() {
		return nightsReserved;
	}

	/**
	 * This method returns the number of guests for the reservation.
	 *
	 * @return an integer value representing the number of guests
	 */
	public int getGuests() {
		return guests;
	}

	/**
	 * This method returns the total price for the reservation.
	 *
	 * @return a double value representing the total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * This method returns the confirmation number for the reservation.
	 *
	 * @return an integer value representing the confirmation number
	 */
	public int getConfirmationNumber() {
		return confirmationNumber;
	}
}