import java.time.LocalDate;
import java.util.ArrayList;

public class Room {

	// roomNumber is passed in through the reservation class
	// Based on the roomtype, the room number takes the next available integer
	// within that type
	// ie. King bed -> 1, then 2, up to 20, then it can't do king any more
	private int roomNumber;
	// bedCount, bedType, pricePerNight, maxGuests, and roomType are all tied to the
	// RoomType, and
	// initialized when a room number is passed in
	private int bedCount;
	private int bedType;
	private int pricePerNight;
	private int maxGuests;
	private RoomType roomType;
	// dateReserved and totalNights passed in from the reservation method, only when
	// reserved
	// private int checkIn;
	// private int checkOut;
	// private int totalNights;
	// isOccupied passed into the calendar array; true at i when someone reserves
	// that day
	private boolean isOccupied;
	// Number of available rooms for each type
	private int availableKing = 20;
	private int availableQueen = 20;
	private int availableSuite = 10;
	// Rate per room per night
	private int kingRoomRate = 250;
	private int queenRoomRate = 200;
	private int suiteRoomRate = 300;
	// roomCalendar acts as a 365 index array tied to a room, it can be used if you
	// pass in a date to a room to check if it is booked or not
	// Use .getDayOfYear() to find the calendar index
	private boolean[] roomCalendar = new boolean[365];
	public ArrayList<Room> roomArray;

	public Room() {
	}

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;

		if (roomNumber <= 20 && roomNumber > 0) { // 20 King suites
			bedCount = 1;
			bedType = 1; // 1 for King bed
			maxGuests = 4;
			this.pricePerNight = kingRoomRate; // $125 per night
			this.roomType = RoomType.KingRoom;
		} else if (roomNumber <= 40 && roomNumber > 20) { // 20 Family suites
			bedCount = 2;
			bedType = 2; // 2 for Queen bed
			maxGuests = 6;
			this.pricePerNight = queenRoomRate; // $175 per night
			this.roomType = RoomType.QueenRoom;
		} else if (roomNumber <= 50 && roomNumber > 40) { // 10 Queen suites
			bedCount = 1;
			bedType = 2; // 2 for Queen bed
			maxGuests = 3;
			this.pricePerNight = suiteRoomRate; // $120 per night
			this.roomType = RoomType.SuiteRoom;
		} else {
			// GUI.roomNumberErrorMessage(); //display an error message from the GUI
		}
	}

	public void addRoom(int roomNumber) {
		roomArray = new ArrayList<>();
		roomArray.add(new Room(roomNumber));
	}

	public boolean getIsOccupied(LocalDate checkInDate, LocalDate checkOutDate) {
		int dayNumber = checkInDate.getDayOfYear() - 1;
		int nightsReserved = checkInDate.until(checkOutDate).getDays();

		for (int i = 0; i <= nightsReserved; i++) {
			if (roomCalendar[dayNumber] == true) {
				isOccupied = true;
				break;
			} else {
				isOccupied = false;
			}
		}
		return isOccupied;
	}

	public void setIsOccupied(LocalDate checkInDate, LocalDate checkOutDate) {
		int dayNumber = checkInDate.getDayOfYear() - 1;
		int nightsReserved = checkInDate.until(checkOutDate).getDays();

		for (int i = 0; i <= nightsReserved; i++) {
			roomCalendar[dayNumber + i] = true;
		}
	}

	public void releaseRoom(int dateReserved) {
		roomCalendar[dateReserved] = false;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public double getBedCount() {
		return bedCount;
	}

	public double getBedType() {
		return bedType;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public int getKingRoomRate() {
		return kingRoomRate;
	}

	public int getQueenRoomRate() {
		return queenRoomRate;
	}

	public int getSuiteRoomRate() {
		return suiteRoomRate;
	}
}

/**
 * 
 * Enumeration of the possible room types.
 */
enum RoomType {
	KingRoom, QueenRoom, SuiteRoom
}
