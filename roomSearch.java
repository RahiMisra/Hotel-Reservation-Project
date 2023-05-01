import java.time.LocalDate;
import java.util.ArrayList;



public class roomSearch {
    private static roomSearch instance;
    private ArrayList<AvailableRooms> roomsList; // an array list of rooms

    private int nights; // the number of nights of stay
    private int day; // the day of the year of the check-in date


    private roomSearch(){
        roomsList = new ArrayList<>();
        for (int i = 0; i < 365; i++) {
            roomsList.add(new AvailableRooms());
        }




    }

    public ArrayList<AvailableRooms> getArray(){
        return roomsList;
    }
    public static  roomSearch getInstance(){
        if(instance==null){
            instance = new roomSearch();
        }
        return instance;
    }


    public int getnumNights() {
        return nights;
    }
    public int getDay(){
        return  day;
    }
    public void checkinDate(LocalDate reservationDate){
        day = reservationDate.getDayOfYear() -1;
    }
    public void setNights(int nights){
        this.nights = nights;
    }



    public boolean checkForAllroomTypes() {


        boolean roomsAvailable = true;

        for (int i = getDay(); i < getDay() + getnumNights(); i++) {
            if (!(roomsList.get(i).isRoomTypeAvailable("king") || roomsList.get(i).isRoomTypeAvailable("queen") || roomsList.get(i).isRoomTypeAvailable("suite"))) {
                roomsAvailable = false;
                break;
            }

        }
        for (int i = getDay(); i < getDay() + getnumNights(); i++) {

            System.out.println(roomsList.get(i).roomsAvailable());
        }
        return roomsAvailable;

    }


    public boolean checkForIndividalroom(String roomtype) {

        boolean Available = true;

        for(int i = getDay(); i < getDay() + getnumNights(); i++) {

            if (!(roomsList.get(i).isRoomTypeAvailable(roomtype))) {
                Available = false;
                break;
            }


        }



        return Available;
    }
    public double getPricePerNight(String roomType){
        System.out.println(roomsList.get(getDay()).getRoomRate(roomType));
        return roomsList.get(getDay()).getRoomRate(roomType);

    }

}
