import java.time.LocalDate;
import java.util.Random;

public class Reservation {
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int nightsReserved;
	private int guests;
	private int totalPrice;
	private int confirmationNumber;
	int roomChoice; // room number selected when someone clicks a room using the gui
	Room reservedRoom = new Room(roomChoice);

	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, int guests, int roomChoice) {
		this.checkInDate = checkInDate; // stored as (yyyy, mm, dd), but can be (yyyy, m, d)
		this.checkOutDate = checkOutDate;
		this.nightsReserved = (int) checkInDate.until(checkOutDate).getDays();
		this.guests = guests;
		this.roomChoice = roomChoice;
		this.totalPrice = calculateTotalPrice();
		this.confirmationNumber = generateConfirmationNumber();

		// reservedRoom.setOccupied(true); // once order is completed, done in GUI if
		// all fields are inputted properly
	}

	private int calculateTotalPrice() {
		totalPrice = reservedRoom.getPricePerNight() * nightsReserved;
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
