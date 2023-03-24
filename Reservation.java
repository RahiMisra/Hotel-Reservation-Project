import java.time.LocalDate;
import java.util.Random;

public class Reservation {
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int nightsReserved;
	private int guests;
	private int totalPrice;
	private int confirmationNumber;

	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, int guests) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.nightsReserved = (int) checkInDate.until(checkOutDate).getDays();
		this.guests = guests;
		this.totalPrice = calculateTotalPrice();
		this.confirmationNumber = generateConfirmationNumber();

		// Room.setOccupied(true);
	}

	private int calculateTotalPrice() {
		totalPrice = Room.pricePerNight * nightsReserved;
		return totalPrice;
	}

	private int generateConfirmationNumber() {
		Random random = new Random();
		confirmationNumber = random.nextInt(999999999 - 100000000 + 1) + 100000000;
		return confirmationNumber;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public int getNightsReserved() {
		return nightsReserved;
	}

	public int getGuests() {
		return guests;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public int getConfirmationNumber() {
		return confirmationNumber;
	}
}
