import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;



public class Reservation extends DatabaseMethods {
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int nightsReserved;
	private int totalPrice;
	private int totalGuests;
	private String roomType;
	private boolean available;
	private int confirmationNumber;
	private int roomNumber;
	public ArrayList<Reservation> reservationArray = new ArrayList<>();
	Room r = new Room();
	
	//initializes the array list to have all of the info from the database
	void initializeReservations(Connection con) {
		reservationArray = getReservation(con, reservationArray);
	}
	
	public Reservation() {
	}
	
	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, int totalGuests, String roomType, int confirmationNumber) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalGuests = totalGuests;
		this.roomType = roomType;
		this.confirmationNumber = confirmationNumber;
	}

	public void reserveRoom(LocalDate checkInDate, LocalDate checkOutDate, int totalGuests, String roomType) {
		Room r = new Room(roomType);
		setRoomNumber(checkInDate, checkOutDate, roomType);

		if (available && totalGuests < r.getMaxGuests()) {
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
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 0 && r.roomArray.get(i).getRoomNumber() <= 20) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							available = false;
							if (roomNumber > 20) {
								break;
							}
							roomNumber++;
						} else {
							available = true;
						}
					}
				}
			}
		} else if (roomType.equals("queen")) {
			roomNumber = 21;
			if (r.roomArray == null) {
				r.addRoom(roomNumber);
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 20 && r.roomArray.get(i).getRoomNumber() <= 40) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							available = false;
							if (roomNumber > 40) {
								break;
							}
							roomNumber++;
						} else {
							available = true;
						}
					}
				}
			}
		} else {
			roomNumber = 41;
			if (r.roomArray == null) {
				r.addRoom(roomNumber);
				available = true;
			} else {
				for (int i = 0; i < r.roomArray.size(); i++) {
					if (r.roomArray.get(i).getRoomNumber() > 40 && r.roomArray.get(i).getRoomNumber() <= 50) {
						if (r.roomArray.get(i).getIsOccupied(checkInDate, checkOutDate)) {
							available = false;
							if (roomNumber > 50) {
								break;
							}
							roomNumber++;
						} else {
							available = true;
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
					if (r.roomArray.get(i).getRoomNumber() > 0 && r.roomArray.get(i).getRoomNumber() <= 20) {
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

	public void addReservation() {
		reservationArray.add(new Reservation());
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

	public boolean getAvailable() {
		return available;
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