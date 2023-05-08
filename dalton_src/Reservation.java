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
	Room r = new Room();

	public Reservation() {

	}

	public void reserveRoom(LocalDate checkInDate, LocalDate checkOutDate, int totalGuests, String roomType) {

		if (!r.getIsOccupied(checkInDate, checkOutDate)) {
			setRoomNumber(checkInDate, checkOutDate, roomType);
			roomNumber = getRoomNumber();
			r.addRoom(roomNumber);
			totalPrice = calculateTotalPrice(r.getPricePerNight());
			confirmationNumber = generateConfirmationNumber();
			r.setIsOccupied(checkInDate, checkOutDate);
		} else {
			// gui.error message
		}
	}

	public void setRoomNumber(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
		if (roomType.equals("king")) {
			roomNumber = 1;
			if (r.roomArray == null) {
				r.addRoom(roomNumber);
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 0 && r.roomArray.get(i).getRoomNumber() < 20) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							if (roomNumber > 20) {
								break;
							}
							roomNumber++;
						}
					}
				}
			}
		} else if (roomType.equals("queen")) {
			roomNumber = 21;
			if (r.roomArray == null) {
				r.addRoom(roomNumber);
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 20 && r.roomArray.get(i).getRoomNumber() <= 40) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							if (roomNumber > 40) {
								break;
							}
							roomNumber++;
						}
					}
				}
			}
		} else {
			roomNumber = 41;
			if (r.roomArray == null) {
				r.addRoom(roomNumber);
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 40 && r.roomArray.get(i).getRoomNumber() <= 50) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							if (roomNumber > 50) {
								break;
							}
							roomNumber++;
						}
					}
				}
			}
		}
	}

	public boolean checkAvailable(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
		int cutoff;
		if (roomType.equals("king")) {
			if (r.roomArray == null) {
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 0 && r.roomArray.get(i).getRoomNumber() < 20) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							available = false;
						} else {
							cutoff = r.roomArray.get(i).getRoomNumber();
							if (cutoff > 20) {
								break;
							}
							available = true;
						}
					}
				}
			}
		} else if (roomType.equals("queen")) {
			if (r.roomArray == null) {
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 20 && r.roomArray.get(i).getRoomNumber() <= 40) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							available = false;
						} else {
							cutoff = r.roomArray.get(i).getRoomNumber();
							if (cutoff > 40) {
								break;
							}
							available = true;
						}
					}
				}
			}
		} else {
			if (r.roomArray == null) {
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 40 && r.roomArray.get(i).getRoomNumber() <= 50) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							available = false;
						} else {
							cutoff = r.roomArray.get(i).getRoomNumber();
							if (cutoff > 20) {
								break;
							}
							available = true;
						}
					}
				}
			}
		}
		return available;
	}

	public int getRoomNumber() {
		return roomNumber;
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
