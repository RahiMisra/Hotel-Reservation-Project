/**
 *
 *
 * The AvailableRooms class represents the available rooms in a hotel.
 *
 * It keeps track of the number of rooms available for each room type and the number of occupied rooms for each type.
 *
 *
 *@author (Alejandro Ortega)
 *@version (1.2)
 */

public class AvailableRooms {

    private final int maxKingBedsAvailable;
    private final int maxQueenBedsAvailable;
    private final int maxSuiteBedsAvailable;
    private int kingBedsOccupied;
    private int queenBedsOccupied;
    private int suiteBedsOccupied;
    private double kingBedroomRate;
    private double queenBedroomRate;
    private double suiteBedroomRate;
    kingBedroomRate = 250;
        queenBedroomRate = 275;
        suiteBedroomRate = 800;

    /**
     * Constructs an AvailableRooms object with default values.
     * There are 20 king rooms, 20 queen rooms, and 10 suite rooms available.
     * All the rooms are initially unoccupied.
     */
    public AvailableRooms() {
        maxKingBedsAvailable = 20;
        maxQueenBedsAvailable = 20;
        maxSuiteBedsAvailable = 10;
        kingBedsOccupied = 0;
        queenBedsOccupied = 0;
        suiteBedsOccupied = 0;
        
    }

    /**
     * Constructs an AvailableRooms object with the specified number of available and occupied rooms for each type.
     *
     * @param maxKingBedsAvailable  the maximum number of king rooms available
     * @param maxQueenBedsAvailable the maximum number of queen rooms available
     * @param maxSuiteBedsAvailable the maximum number of suite rooms available
     * @param kingBedsOccupied      the number of king rooms that are currently occupied
     * @param queenBedsOccupied     the number of queen rooms that are currently occupied
     * @param suiteBedsOccupied     the number of suite rooms that are currently occupied
     */
    public AvailableRooms(int maxKingBedsAvailable, int maxQueenBedsAvailable, int maxSuiteBedsAvailable,
                          int kingBedsOccupied, int queenBedsOccupied, int suiteBedsOccupied) {
        this.maxKingBedsAvailable = maxKingBedsAvailable;
        this.maxQueenBedsAvailable = maxQueenBedsAvailable;
        this.maxSuiteBedsAvailable = maxSuiteBedsAvailable;
        this.kingBedsOccupied = kingBedsOccupied;
        this.queenBedsOccupied = queenBedsOccupied;
        this.suiteBedsOccupied = suiteBedsOccupied;
        kingBedroomRate = 250;
        queenBedroomRate = 275;
        suiteBedroomRate = 800;
    }
     public void setRoomRate(String roomType, double BedroomRate) {
        if(roomType.equals("king")){
            kingBedroomRate = BedroomRate;
        } else if (roomType.equals("queen")) {
            queenBedroomRate = BedroomRate;

        } else if (roomType.equals("suite")) {
            suiteBedroomRate = BedroomRate;

        }


    }

    public double getRoomRate(String roomType){

        if(roomType.equals("king")){
            return kingBedroomRate;
        } else if (roomType.equals("queen")) {
            return queenBedroomRate;

        } else if (roomType.equals("suite")) {
            return suiteBedroomRate;

        }
        else
        {
            throw new IllegalArgumentException("Invalid room type: " + roomType);
        }
    }

    /**
     * Reserves a room of the specified type.
     *
     * @param room the type of room to reserve (king, queen, or suite)
     */
    public void reserveRoom(String room) {
        if (room.equals("king")) {
            kingBedsOccupied++;
        } else if (room.equals("queen")) {
            queenBedsOccupied++;
        } else if (room.equals("suite")) {
            suiteBedsOccupied++;
        }
    }

    /**
     * Releases a room of the specified type.
     *
     * @param room the type of room to release (king, queen, or suite)
     */
    public void releaseRoom(String room) {
        if (room.equals("king")) {
            kingBedsOccupied--;
        } else if (room.equals("queen")) {
            queenBedsOccupied--;
        } else if (room.equals("suite")) {
            suiteBedsOccupied--;
        }
    }

    /**
     * Checks if there is at least one room of the specified type available.
     *
     * @param roomtype the type of room to check availability for (king, queen, or suite)
     * @return true if at least one room of the specified type is available, false otherwise
     */
    public boolean isRoomTypeAvailable(String roomtype) {
        boolean isAvailable = false;
        if (roomtype == "king") {
            isAvailable = KingRoomsLeft() > 0;
        } else if (roomtype == "queen") {
            isAvailable = QueenRoomsLeft() > 0;
        } else if (roomtype == "suite") {
            isAvailable = QueenRoomsLeft() > 0;
        }
        return isAvailable;

    }


    /**
     * gets the number of king bed rooms available.
     *
     * @return the number of king size bed rooms available.
     */
    public int KingRoomsLeft() {
        return maxKingBedsAvailable - kingBedsOccupied;
    }

    /**
     * gets the number of Queen bed rooms available.
     *
     * @return the number of Queen size bed rooms available.
     */
    public int QueenRoomsLeft() {
        return maxQueenBedsAvailable - queenBedsOccupied;
    }

    /**
     * gets the number of Suite bed rooms available.
     *
     * @return the number of Queen size bed rooms available.
     */
    public int SuiteRoomsLeft() {
        return maxSuiteBedsAvailable - suiteBedsOccupied;
    }

    /**
     * provides a string to the number of king, Queen, and suite bed rooms available.
     *
     * @return a list of available rooms.
     */
    public String roomsAvailable() {


        return "kingrooms available " + KingRoomsLeft() + "\n"
                + "queenrooms available: " + QueenRoomsLeft() + "\n"
                + "suiterooms available: " + SuiteRoomsLeft() + "\n";
    }

}




