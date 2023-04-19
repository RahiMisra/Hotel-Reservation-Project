/**
 * 
 * This class represents a room in a hotel and all of its attributes
 */
public class Room {

	/**
	 * 
	 * The room number of the room.
	 */
	private int roomNumber;
	/**
	 * 
	 * The type of room (Master Suite, Family Suite, Queen Suite).
	 */
	private RoomType roomType;
	/**
	 * 
	 * The number of beds in the room (1 or 2).
	 */
	private int bedCount;
	/**
	 * 
	 * The type of bed in the room (1 = King, 2 = Queen).
	 */
	private int bedType;
	/**
	 * 
	 * The price per night for the room.
	 */
	private int pricePerNight;
	/**
	 * 
	 * The maximum number of guests that can occupy the room.
	 */
	private int maxGuests;
	/**
	 * 
	 * A boolean indicating whether the room is currently occupied or not.
	 */
	private boolean isOccupied;
	/**
	 * 
	 * The number of available master suites in the hotel.
	 */
	private int availableMaster = 20;
	/**
	 * 
	 * The number of available family suites in the hotel.
	 */
	private int availableFamily = 20;
	/**
	 * 
	 * The number of available queen suites in the hotel.
	 */
	private int availableQueen = 10;

	/**
	 * 
	 * Constructs a Room object with the given room number.
	 * 
	 * @param roomNumber the room number of the room
	 */
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
		this.isOccupied = false;

		if (roomNumber <= 20 && roomNumber > 0) { // 20 King suites
			bedCount = 1;
			bedType = 1; // 1 for King bed
			maxGuests = 4;
			this.pricePerNight = 140; // $125 per night
			this.roomType = RoomType.MasterSuite;
		} else if (roomNumber <= 40 && roomNumber > 20) { // 20 Family suites
			bedCount = 2;
			bedType = 2; // 2 for Queen bed
			maxGuests = 6;
			this.pricePerNight = 175; // $175 per night
			this.roomType = RoomType.FamilySuite;
		} else if (roomNumber <= 50 && roomNumber > 40) { // 10 Queen suites
			bedCount = 1;
			bedType = 2; // 2 for Queen bed
			maxGuests = 3;
			this.pricePerNight = 120; // $120 per night
			this.roomType = RoomType.QueenSuite;
		} else {
// GUI.roomNumberErrorMessage(); //display an error message from the GUI
		}
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
	public boolean getIsOccupied() {
		return isOccupied;
	}

	/**
	 * 
	 * Reserves the room if it's available and of the requested type. If the room is
	 * reserved successfully, decrement the available rooms count.
	 */
	public void reserveRoom() {
		if (roomType == RoomType.MasterSuite && availableMaster >= 1 && !isOccupied) {
			isOccupied = true;
			availableMaster--;
		} else if (roomType == RoomType.FamilySuite && availableFamily >= 1 && !isOccupied) {
			isOccupied = true;
			availableFamily--;
		} else if (roomType == RoomType.QueenSuite && availableQueen >= 1 && !isOccupied) {
			isOccupied = true;
			availableQueen--;
		}
	}

	/**
	 * 
	 * Releases the room if it's currently occupied and of the requested type. If
	 * the room is released successfully, increment the available rooms count.
	 */
	public void releaseRoom() {
		if (roomType == RoomType.MasterSuite && isOccupied) {
			isOccupied = false;
			availableMaster++;
		} else if (roomType == RoomType.FamilySuite && isOccupied) {
			isOccupied = false;
			availableFamily++;
		} else if (roomType == RoomType.QueenSuite && isOccupied) {
			isOccupied = false;
			availableQueen++;
		}
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
}

/**
 * 
 * Enumeration of the possible room types.
 */
enum RoomType {
	MasterSuite, FamilySuite, QueenSuite
}