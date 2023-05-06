import java.time.LocalDate;
import java.util.Random;

public class Reservation {
	// checkInDate and checkOutDate are inputs passed into java.time.LocalDate
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	// nightsReserved is an int value of the number of days between two specified
	// dates
	// totalPrice is nightsReserved * room.pricePerNight
	// nightsReserved = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
	private int nightsReserved;
	private int dayNumber;
	private int totalPrice;
	// totalGuests and roomType are inputs from the customer
	private int totalGuests;
	private String roomType;
	// confirmationNumber is a randomly generated number
	// roomNumber is the next available number for a specific roomType, checked by
	// the room class array of rooms
	private boolean available;
	private int confirmationNumber;
	private int roomNumber;

	public Reservation() {

	}

	public void reserveRoom(LocalDate checkInDate, LocalDate checkOutDate, int totalGuests, String roomType) {
		dayNumber = checkInDate.getDayOfYear() - 1;
		nightsReserved = checkInDate.until(checkOutDate).getDays();

		if (checkAvailable(checkInDate, checkOutDate, roomType)) {
			Room reservedRoom = new Room(roomNumber);
			reservedRoom.addRoom(roomNumber);
			totalPrice = calculateTotalPrice(reservedRoom.getPricePerNight());
			confirmationNumber = generateConfirmationNumber();
			for (int i = 0; i <= nightsReserved; i++) {
				reservedRoom.setIsOccupied(dayNumber + i);
			}
		} else {
			// gui.error message
		}
	}

	public boolean checkAvailable(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
		Room r = new Room();

		if (roomType.equals("king")) {
			roomNumber = 1;
			if (r.roomArray.size() == 0) {
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 0 && r.roomArray.get(i).getRoomNumber() < 20) {
						for (int j = 0; j <= nightsReserved; j++) {
							if (r.roomArray.get(i).getIsOccupied(dayNumber + j)) {
								roomNumber++;
								available = false;
								break;
							} else {
								available = true;
							}
						}
					}
				}
			}
		} else if (roomType.equals("queen")) {
			roomNumber = 21;
			if (r.roomArray.size() == 0) {
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 20 && r.roomArray.get(i).getRoomNumber() <= 40) {
						roomNumber = 21;
						for (int j = 0; j <= nightsReserved; j++) {
							if (r.roomArray.get(i).getIsOccupied(dayNumber + j)) {
								roomNumber++;
								available = false;
								break;
							} else {
								available = true;
							}
						}
					}
				}
			}
		} else {
			roomNumber = 41;
			if (r.roomArray.size() == 0) {
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 40 && r.roomArray.get(i).getRoomNumber() <= 50) {
						roomNumber = 41;
						for (int j = 0; j <= nightsReserved; j++) {
							if (r.roomArray.get(i).getIsOccupied(dayNumber + j)) {
								roomNumber++;
								available = false;
								break;
							} else {
								available = true;
							}
						}
					}
				}
			}
		}
		return available;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
		this.nightsReserved = getCheckInDate().until(checkOutDate).getDays();
	}

	public void setGuests(int guests) {
		this.totalGuests = guests;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomType() {
		return roomType;
	}

	public int calculateTotalPrice(int pricePerNight) {
		totalPrice = (pricePerNight * nightsReserved);
		return totalPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public int generateConfirmationNumber() {
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
		return totalGuests;
	}

	public int getConfirmationNumber() {
		return confirmationNumber;
	}
}
