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
	// private int availableKing = 20;
	// private int availableQueen = 20;
	// private int availableSuite = 10;
	// Rate per room per night
	private int kingRoomRate = 250;
	private int queenRoomRate = 200;
	private int suiteRoomRate = 300;
	// roomCalendar acts as a 365 index array tied to a room
	// It can be used if you pass in a date to a room to check if it is booked or
	// not
	private boolean[] roomCalendar = new boolean[365]; // starting from 2023-01-01 to 2023-12-31
	// to convert a date into a number, just find dayNumber = (int)
	// LocalDate.parse("2023-01-01").until(checkOutDate).getDays();
	// roomArray adds a room to the general array, and can be used to show all
	// current booked rooms
	public ArrayList<Room> roomArray;

	public Room() {
	}

	// We want to store the available variables in the database and access from
	// there
	// We also want to store the reservation in the database, with a room attached
	// and the date too
	/**
	 * 
	 * Constructs a Room object with the given room number.
	 * 
	 * @param roomNumber the room number of the room
	 */
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

	/**
	 * 
	 * Gets the room number of the room.
	 * 
	 * @return the room number of the room
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * 
	 * Gets the type of room.
	 * 
	 * @return the type of room
	 */
	public RoomType getRoomType() {
		return roomType;
	}

	/**
	 * 
	 * Gets whether the room is currently occupied.
	 * 
	 * @return true if the room is currently occupied, false otherwise
	 */
	public boolean getIsOccupied(int dateReserved) { // find a way to convert the date into an integer that lines up
														// with the calendar array
		if (roomCalendar[dateReserved] == true) {
			isOccupied = true;
		} else {
			isOccupied = false;
		}
		return isOccupied;
	}

	/**
	 * 
	 * Reserves the room if it's available and of the requested type. If the room is
	 * reserved successfully, decrement the available rooms count.
	 */
	public void setIsOccupied(int dateReserved) {
		roomCalendar[dateReserved] = true;
	}

	/**
	 * 
	 * Releases the room if it's currently occupied and of the requested type. If
	 * the room is released successfully, increment the available rooms count.
	 */
	public void releaseRoom(int dateReserved) {
		roomCalendar[dateReserved] = false;
	}

	/**
	 * 
	 * Returns the price per night of the room.
	 * 
	 * @return the price per night of the room
	 */
	public int getPricePerNight() {
		return pricePerNight;
	}

	/**
	 * 
	 * Returns the number of beds in the room.
	 * 
	 * @return the number of beds in the room
	 */
	public double getBedCount() {
		return bedCount;
	}

	/**
	 * 
	 * Returns the type of the beds in the room.
	 * 
	 * @return the type of the beds in the room
	 */
	public double getBedType() {
		return bedType;
	}

	/**
	 * 
	 * Returns the maximum number of guests allowed in the room.
	 * 
	 * @return the maximum number of guests allowed in the room
	 */
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
