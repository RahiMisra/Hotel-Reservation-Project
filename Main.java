import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

class Main extends DatabaseMethods{

  public static void main(String[] args) {
//makes a connection to the database server
    Connection con = getConnection();
   //check if the database connects
  if (testDatabaseconnection(con)) {
    System.out.println("Database connection successful!");
  }
  else {
    System.out.println("Database connection failed.");
  }
    Scanner KB = new Scanner(System.in);
  
    boolean menu = true;
    
    while(menu) {
      char selection;
      System.out.println();

      System.out.println("WELCOME TO THE BUG-BYTE HOTEL RESERVATION SYSTEM");
      System.out.println("-------------------------------------------------");
      System.out.println("Please select from the menu below");
      System.out.println("A.Book a room");
      System.out.println("B.Check room availability");

      System.out.print("Enter Selection: ");

      selection = KB.next().charAt(0);

      switch(selection){
        case 'A':
          CheckIn();
          break;
        case 'B':
          Room();
          break;
          default:
          System.out.println("Invaild Selection");
      }
    }
    KB.close();
    
  }

  public static void Room() {

    int roomNum;

  }
 

  public static void CheckIn(){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("HotelInput.txt"));
         
    Scanner KB = new Scanner(System.in);
    
    System.out.print("Please enter your full name separated by '_': ");
    String name = KB.next();
    
    System.out.print("Please enter your mobile number: ");
    int phoneNum = KB.nextInt();
    
    System.out.print("Please enter your email address: ");
    String email = KB.next();

    Customer customer = new Customer(name, phoneNum, email);

    writer.write(customer.name + ", ");
    writer.write(String.valueOf(customer.phoneNum) + ", ");
    writer.write(customer.email);

    System.out.println("You have entered " +name+ ", " +phoneNum+ ", and "+email);

    KB.close();
    writer.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
  }
}
