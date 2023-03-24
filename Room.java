/* 
 * Room class used to hold room information.
 * 
 * Room variables:
 * 		- Number of beds
 * 		- Bed type (King, queen, twin)
 * 		- Price per night
 * 		// Number of rooms and bathrooms always just 1
 * Room types as described: 
 * 		- Master Suite (1 King)
 * 		- Family Suite (2 Queens)
 * 		- Queen Suite (1 Queen)
 */

public class Room {

	private int roomNumber;
	private RoomType roomType;
	private int bedCount; // Either 1 bed or 2 bed rooms
	private int bedType; // 1 = King, 2 = Queen
	private int pricePerNight; // A specific price per night
	private boolean isOccupied;

	public Room(int roomNumber, RoomType roomType) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.isOccupied = false;

		if (roomType == RoomType.MasterSuite) {
			bedCount = 1;
			bedType = 1; // 1 for King bed
			this.pricePerNight = 140; // $125 per night
		} else if (roomType == RoomType.FamilySuite) {
			bedCount = 2;
			bedType = 2; // 2 for Queen bed
			this.pricePerNight = 175; // $175 per night
		} else { // Queen suite
			bedCount = 1;
			bedType = 2; // 2 for Queen bed
			this.pricePerNight = 120; // $120 per night
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

	public double getPricePerNight() {
		return pricePerNight;
	}

	public double getBedCount() {
		return bedCount;
	}

	public double getBedType() {
		return bedType;
	}
}

enum RoomType {
	MasterSuite, FamilySuite, QueenSuite
}
