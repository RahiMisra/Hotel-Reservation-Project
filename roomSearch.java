import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * The roomSearch class provides methods for searching and reserving hotel rooms.
 * @author (Alejandro Ortega, Dalton Wiggins)
 *  *@version (1.2)

 */
public class roomSearch {
    private ArrayList<AvailableRooms> roomsArray; // an array list of rooms
    private LocalDate checkinDate; // the check-in date
    private LocalDate checkoutDate; // the check-out date
    private int nights; // the number of nights of stay
    private int day; // the day of the year of the check-in date
    private int roomtypeChoice; // the room type chosen by the user

    /**
     * The roomSearch constructor initializes the roomsArray with an ArrayList of rooms objects for each day of the year.
     * The default check-in date is set to January 1, 2012.
     */
    roomSearch() {
        checkinDate = LocalDate.parse("2012-01-01");
        roomsArray = new ArrayList<>();
        for (int i = 0; i < 365; i++) {
            roomsArray.add(new AvailableRooms());
        }
    }

    /**
     * The reserveRoom method reserves a room of the specified roomtype on the day of the check-in date.
     *
     * @param roomtype the type of the room to reserve (1 for King Bed, 2 for Queen Bed, 3 for Suite Bed)
     */
    public void reserveRoom(int roomtype) {
        if (roomtype == 1 && roomsArray.get(day).isKingBedAvailable()) {
            roomsArray.get(day).reserveKingBedRoom();
        } else if (roomtype == 2 && roomsArray.get(day).isQueenBedAvailable()) {
            roomsArray.get(day).reserveQueenBedRoom();
        } else if (roomtype == 3 && roomsArray.get(day).isSuiteBedAvailable()) {
            roomsArray.get(day).reserveSuiteBedRoom();
        }
    }

    /**
     * The releaseRoom method releases a room of the specified roomtype on the day of the check-in date.
     *
     * @param roomtype the type of the room to release (1 for King Bed, 2 for Queen Bed, 3 for Suite Bed)
     */
    public void releaseRoom(int roomtype) {
        if (roomtype == 1) {
            roomsArray.get(day).releaseKingBedRoom();
        } else if (roomtype == 2) {
            roomsArray.get(day).releaseQueenBedRoom();
        } else if (roomtype == 3) {
            roomsArray.get(day).releaseSuiteBedRoom();
        }
    }

    /**
     * The setCheckInCheckOut method sets the check-in and check-out dates and calculates the number of nights of stay.
     *
     * @param checkInDate  the check-in date
     * @param checkOutDate the check-out date
     */
    public void setCheckInCheckOut(LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkinDate = checkInDate;
        this.checkoutDate = checkOutDate;
        day = (getCheckinDate().getDayOfYear() - 1);
        nights = checkInDate.until(checkOutDate).getDays();
    }

    /**
     * The getnumNights method returns the number of nights of stay.
     *
     * @return the number of nights of stay
     */
    public int getnumNights() {
        return nights;
    }

    /**
     * The getCheckinDate method returns the check-in date.
     *
     * @return the check-in date
     */
    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    /**
     * The checkForAllroomTypes method check for all room types availablity for multiple days.
     *
     * @return true if rooms are available across sequence of days
     */

    public boolean checkForAllroomTypes() {


        boolean roomsAvailable = true;

        for (int i = day; i < day + getnumNights(); i++) {
            if (!(roomsArray.get(i).isKingBedAvailable() || roomsArray.get(i).isQueenBedAvailable() || roomsArray.get(i).isSuiteBedAvailable())) {
                roomsAvailable = false;
                break;
            }

        }

        System.out.println(getCheckinDate());
        for (int i = day; i < day + getnumNights(); i++) {

            System.out.println(roomsArray.get(i).roomsAvailable());
        }


        return roomsAvailable;

    }

    /**
     * Sets the room choice of the user.
     *
     * @param roomChoice the integer value representing the room choice of the user.
     */
    public void setroomchoice(int roomChoice) {
        this.roomtypeChoice = roomChoice;
    }

    /**
     * Returns the room type choice of the user.
     *
     * @return an integer representing the room type choice of the user.
     */
    public int getroomtypeChoice() {
        return roomtypeChoice;
    }

    /**
     * Checks if the given room type is available for individual booking.
     *
     * @param roomtype a string representing the type of room to be checked for availability.
     * @return a boolean value indicating whether the room type is available for individual booking or not.
     */
    public boolean checkForIndividalroom(String roomtype) {
// method implementation goes here

        boolean Available = true;
        int day = (getCheckinDate().getDayOfYear() - 1);
        for (int i = day; i <= day + getnumNights(); i++) {
            if (roomtype.equals("king")) {
                if (!(roomsArray.get(i).isKingBedAvailable())) {
                    Available = false;
                    break;
                }
            } else if (roomtype.equals("queen")) {
                if (!(roomsArray.get(i).isQueenBedAvailable())) {
                    Available = false;
                    break;
                }
            } else if (roomtype == "suite") {
                if (!(roomsArray.get(i).isSuiteBedAvailable())) {
                    Available = false;
                    break;
                }

            }


        }
        return Available;
    }
}
