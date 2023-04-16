public class rooms {


    private final int maxKingbedsAvailable;
    private final int maxQueenbedsAvailable;

    private final int maxSuitebedsAvailable;

    private int kingbedsOccupied;
    private int queenbedsOccupied;
    private int suitebedsOccupied;


    public rooms() {
        maxKingbedsAvailable = 20;
        maxQueenbedsAvailable = 20;
        maxSuitebedsAvailable = 10;

        kingbedsOccupied = 0;
        queenbedsOccupied = 0;
        suitebedsOccupied = 0;


    }
    public rooms(int maxKingbedsAvailable,int maxQueenbedsAvailable, int maxSuitebedsAvailable, int kingbedsOccupied, int queenbedsOccupied, int suitebedsOccupied) {
        this.maxKingbedsAvailable = maxKingbedsAvailable;
        this.maxQueenbedsAvailable = maxQueenbedsAvailable;
        this.maxSuitebedsAvailable=maxSuitebedsAvailable;

        this.kingbedsOccupied = kingbedsOccupied;
        this.queenbedsOccupied = queenbedsOccupied;
        this.suitebedsOccupied = suitebedsOccupied;


    }
    public void reserveKingBedRoom() {

        kingbedsOccupied++;
    }
    public void reserveQueenBedRoom() {

        queenbedsOccupied++;
    }
    public void reserveSuiteBedRoom() {

        suitebedsOccupied++;
    }
    public void releaseKingBedRoom() {

        kingbedsOccupied--;
    }
    public void releaseQueenBedRoom() {

        queenbedsOccupied--;
    }
    public void releaseSuiteBedRoom() {

        suitebedsOccupied--;
    }

    public boolean isKingBedAvailable() {
        if (KingRoomsLeft()>0) {

            return true;
        } else
            return false;
    }

    public boolean isQueenBedAvailable() {
        if (QueenRoomsLeft() >0) {

            return true;
        } else
            return false;
    }



    public boolean isSuiteBedAvailable() {
        if (SuiteRoomsLeft() >0) {

            return true;
        } else
            return false;
    }

    public int KingRoomsLeft(){
        return maxKingbedsAvailable-kingbedsOccupied;
    }
    public int QueenRoomsLeft(){
        return maxQueenbedsAvailable-queenbedsOccupied;
    }
    public int SuiteRoomsLeft(){
        return maxSuitebedsAvailable-suitebedsOccupied;
    }



    public  String roomsAvailable(){


        return "kingrooms available "+KingRoomsLeft() +"\n"
                + "queenrooms available: " + QueenRoomsLeft() + "\n"
                + "suiterooms available: "+ SuiteRoomsLeft() +"\n";
    }




}
