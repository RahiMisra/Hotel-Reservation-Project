import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Main {

  public static void main(String[] args) {
    
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

    Scanner KB = new Scanner(System.in);
      int numOfRoom = 10;
    
      while(numOfRoom == 10){
        System.out.println("We have "+ numOfRoom +" rooms available ");
      }
      
      KB.close();
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

    writer.write(name + ", ");
    writer.write(String.valueOf(phoneNum) + ", ");
    writer.write(email);

    System.out.println("You have entered " +name+ ", " +phoneNum+ ", and "+email);

    KB.close();
    writer.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
  }
}
