import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class roomSearch {
    private  ArrayList<rooms> roomsArray;
    private LocalDate checkinDate;
    private  LocalDate checkoutDate;
    private  int nights;

    private int day;


    private int roomtypeChoice;

    roomSearch() {
        checkinDate = LocalDate.parse("2012-01-01");

        roomsArray= new ArrayList<>();
        for (int i = 0; i < 365; i++) {
            roomsArray.add(new rooms());

        }


    }
    public void reserveRoom(int roomtype){

        if(roomtype==1 && roomsArray.get(day).isKingBedAvailable()){

            roomsArray.get(day).reserveKingBedRoom();
        }
        else if(roomtype==2 && roomsArray.get(day).isQueenBedAvailable()){

            roomsArray.get(day).reserveQueenBedRoom();
        }
        else if(roomtype==3 && roomsArray.get(day).isSuiteBedAvailable()){

            roomsArray.get(day).reserveSuiteBedRoom();
        }

    }
    public void releaseRoom(int roomtype){
        if(roomtype==1){
            roomsArray.get(day).releaseKingBedRoom();
        } else if (roomtype==2) {
            roomsArray.get(day).releaseQueenBedRoom();

        } else if (roomtype==3) {
            roomsArray.get(day).releaseSuiteBedRoom();

        }
    }


    public void setCheckInCheckOut(LocalDate checkInDate, LocalDate checkOutDate)
    {
        this.checkinDate = checkInDate;
        this.checkoutDate = checkOutDate;
        day = (getCheckinDate().getDayOfYear()-1);
        nights = checkInDate.until(checkOutDate).getDays();

    }


    public int getnumNights()
    {
        return nights;
    }
    public LocalDate getCheckinDate()
    {
        return checkinDate;
    }

    public boolean checkForAllroomTypes()
    {


        boolean roomsAvailable=true;

        for(int i = day; i<day+getnumNights();i++){
            if(!(roomsArray.get(i).isKingBedAvailable()|| roomsArray.get(i).isQueenBedAvailable()||roomsArray.get(i).isSuiteBedAvailable()))
            {
                roomsAvailable = false;
                break;
            }

        }

        System.out.println(getCheckinDate());
        for(int i = day; i<day+getnumNights();i++){

            System.out.println(roomsArray.get(i).roomsAvailable());
        }



        return roomsAvailable;

    }
    public void setroomchoice(int roomChoice){
        this.roomtypeChoice = roomChoice;


    }
    public int getroomtypeChoice()
    {
        return roomtypeChoice;
    }
    public boolean checkForIndividalroom( String roomtype) {


        boolean Available =true;
        int day = (getCheckinDate().getDayOfYear() - 1);
        for (int i = day; i <= day + getnumNights(); i++) {
            if(roomtype.equals("king")){
                if (!(roomsArray.get(i).isKingBedAvailable())) {
                    Available = false;
                    break;
                }
            } else if (roomtype.equals("queen")) {
                if (!(roomsArray.get(i).isQueenBedAvailable())) {
                    Available = false;
                    break;
                }
            }
            else if (roomtype=="suite") {
                if (!(roomsArray.get(i).isSuiteBedAvailable())) {
                    Available = false;
                    break;
                }

            }


        }
        return Available;
    }

}