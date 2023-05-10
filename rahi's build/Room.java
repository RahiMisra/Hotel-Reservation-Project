import java.time.LocalDate;
import java.util.ArrayList;

public class Room {

	private int roomNumber;
	private int bedCount;
	private int bedType;
	private int pricePerNight;
	private int maxGuests;
	private RoomType roomType;
	private boolean isOccupied;
	private int kingRoomRate = 250;
	private int queenRoomRate = 200;
	private int suiteRoomRate = 300;
	private boolean[] roomCalendar = new boolean[365];
	public ArrayList<Room> roomArray;

	public Room() {
	}

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;

		if (roomNumber <= 20 && roomNumber > 0) {
			bedCount = 1;
			bedType = 1;
			maxGuests = 4;
			this.pricePerNight = kingRoomRate;
			this.roomType = RoomType.KingRoom;
		} else if (roomNumber <= 40 && roomNumber > 20) {
			bedCount = 2;
			bedType = 2;
			maxGuests = 6;
			this.pricePerNight = queenRoomRate;
			this.roomType = RoomType.QueenRoom;
		} else if (roomNumber <= 50 && roomNumber > 40) {
			bedCount = 1;
			bedType = 2;
			maxGuests = 3;
			this.pricePerNight = suiteRoomRate;
			this.roomType = RoomType.SuiteRoom;
		}
	}

	public Room(String roomType) {
		if (roomType.equals("king")) {
			bedCount = 1;
			bedType = 1;
			maxGuests = 4;
			this.pricePerNight = kingRoomRate;
			this.roomType = RoomType.KingRoom;
		} else if (roomType.equals("queen")) {
			bedCount = 2;
			bedType = 2;
			maxGuests = 6;
			this.pricePerNight = queenRoomRate;
			this.roomType = RoomType.QueenRoom;
		} else {
			bedCount = 1;
			bedType = 2;
			maxGuests = 3;
			this.pricePerNight = suiteRoomRate;
			this.roomType = RoomType.SuiteRoom;
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