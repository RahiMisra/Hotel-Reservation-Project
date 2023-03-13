class UMLcode {
    
    public class staff {
        boolean staff;

            public void logIntoStaffAccount(){
                staff = true;
            }
    }

    public class staff_Account {
        boolean staff;

        public void viewBookings(){

        }
    } 

    public class User {
        String name;
        String userName;
        String password;
        String email;
        int phoneNumber;

        public void makeAccount(){

        }

        public void logIntoUserAccount(){

        }

    }

    public class Room{

        int roomNumber;
        int floor;
        int bedrooms;
        int bathrooms;
        int beds;
        int bedSize;
        float price;
    }

    public class Manager {
        boolean admin;

        public void logIntoManagerAcccount(){

        }
    }

    public class Manager_Account {
        boolean admin;

        public void viewBookings(){

        }
        public void setPrices(){

        }
        public void makeStaffAccount() {

        }
        
    }

    public class Reservation {
        int roomNumber;
        String date;
        int price;
        String userName;

    }

    public class User_Account {
        String name;
        String userName;
        String password;
        String email;
        int phoneNumber;

        public void makeReservation() {

        }
        public void searchForRoom() {

        }
    }

    public class Payment_Account {
        String name;
        String userName;
        String paymentType;
        String cardNumber;
        int CCV;
        String expirationDate;
        String country;
        String address;

        public void makePayment() {
            
        }
    }




}