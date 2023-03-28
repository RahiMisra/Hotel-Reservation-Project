/* 
 * Room class used to hold room information.
 * 
 * Room variables:
 * 		- Number of beds
 * 		- Bed type (King, queen, twin)
 * 		- Price per night
 * 		// Number of rooms and bathrooms always just 1
 * Room types as described: 
 * 		- Master Suite (1 King bed)
 * 		- Family Suite (2 Queen beds)
 * 		- Queen Suite (1 Queen bed)
 */

public class Room {

	private int roomNumber;
	private RoomType roomType;
	private int bedCount; // Either 1 bed or 2 bed rooms
	private int bedType; // 1 = King, 2 = Queen
	private int pricePerNight; // A specific price per night
	private int maxGuests;
	private boolean isOccupied;

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
		}
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
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
}

enum RoomType {
	MasterSuite, FamilySuite, QueenSuite
}