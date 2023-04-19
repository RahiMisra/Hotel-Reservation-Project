/**
 *
 * The AvailableRooms class represents rooms in  a hotel with rooms of various types.
 *Rooms can be reserved or released, and their availability can be checked.
 *@author (Alejandro Ortega)
 *@version (1.3)
 *
 */
public class AvailableRooms {
    /**
     * represents the maximum amount of king bedrooms available.
     */
    private final int maxKingBedsAvailable;
    /**
     * represents the maximum amount of queen bedrooms available.
     */
    private final int maxQueenBedsAvailable;
    /**
     * represents the maximum amount of suite bedrooms available.
     */
    private final int maxSuiteBedsAvailable;
    /**
     * represents  king bedrooms occupied.
     */
    private int kingBedsOccupied;
    /**
     * represents  queen bedrooms occupied.
     */
    private int queenBedsOccupied;
    /**
     * represents  suite bedrooms occupied.
     */
    private int suiteBedsOccupied;

    /**
     * Constructs a new Rooms object with default values.
     * There are 20 king-sized beds, 20 queen-sized beds, and 10 suite beds available.
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
     * Constructs a new Rooms object with specified maximum bed and occupancy values.
     * @param maxKingBedsAvailable the maximum number of king-sized beds available
     * @param maxQueenBedsAvailable the maximum number of queen-sized beds available
     * @param maxSuiteBedsAvailable the maximum number of suite beds available
     * @param kingBedsOccupied the current number of occupied king-sized beds
     * @param queenBedsOccupied the current number of occupied queen-sized beds
     * @param suiteBedsOccupied the current number of occupied suite beds
     */

    public rooms(int maxKingBedsAvailable, int maxQueenBedsAvailable, int maxSuiteBedsAvailable, int kingBedsOccupied, int queenBedsOccupied, int suiteBedsOccupied) {
        this.maxKingBedsAvailable = maxKingBedsAvailable;
        this.maxQueenBedsAvailable = maxQueenBedsAvailable;
        this.maxSuiteBedsAvailable = maxSuiteBedsAvailable;
        this.kingBedsOccupied = kingBedsOccupied;
        this.queenBedsOccupied = queenBedsOccupied;
        this.suiteBedsOccupied = suiteBedsOccupied;
    }

    /**
     * Reserves a king-sized bed room.
     */
    public void reserveKingBedRoom() {
        kingBedsOccupied++;
    }

    /**
     * Reserves a queen-sized bed room.
     */
    public void reserveQueenBedRoom() {
        queenBedsOccupied++;
    }

    /**
     * Reserves a suite bed room.
     */
    public void reserveSuiteBedRoom() {
        suiteBedsOccupied++;
    }

    /**
     * Releases a king-sized bed room.
     */
    public void releaseKingBedRoom() {
        kingBedsOccupied--;
    }

    /**
     * Releases a queen-sized bed room.
     */
    public void releaseQueenBedRoom() {
        queenBedsOccupied--;
    }

    /**
     * Releases a suite bed room.
     */
    public void releaseSuiteBedRoom() {
        suiteBedsOccupied--;
    }

    /**
     * Returns true if at least one king-sized bed room is available, false otherwise.
     * @return true if a king-sized bed room is available, false otherwise
     */
    public boolean isKingBedAvailable() {
        return KingRoomsLeft() > 0;
    }

    /**
     * Returns true if at least one queen-sized bed room is available, false otherwise.
     * @return true if a queen-sized bed room is available, false otherwise
     */
    public boolean isQueenBedAvailable() {
        return QueenRoomsLeft() > 0;
    }


    /**
     * checks to see if suite bedrooms are available, false otherwise.
     * @return true if a suite bed room is available, false otherwise
     */
    public boolean isSuiteBedAvailable() {
        if (SuiteRoomsLeft() >0) {

            return true;
        } else
            return false;
    }
    /**
     * gets the number of king bed rooms available.
     * @return the number of king size bed rooms available.
     */
    public int KingRoomsLeft(){
        return maxKingBedsAvailable-kingBedsOccupied;
    }
    /**
     * gets the number of Queen bed rooms available.
     * @return the number of Queen size bed rooms available.
     */
    public int QueenRoomsLeft(){
        return maxQueenBedsAvailable  -queenBedsOccupied;
    }
    /**
     * gets the number of Suite bed rooms available.
     * @return the number of Queen size bed rooms available.
     */
    public int SuiteRoomsLeft(){
        return maxSuiteBedsAvailable-suiteBedsOccupied;
    }


    /**
     * provides a string to the number of king, Queen, and suite bed rooms available.
     * @return a list of available rooms.
     */
    public  String roomsAvailable(){


        return "kingrooms available "+KingRoomsLeft() +"\n"
                + "queenrooms available: " + QueenRoomsLeft() + "\n"
                + "suiterooms available: "+ SuiteRoomsLeft() +"\n";
    }



}
