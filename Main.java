import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

class Main {

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

      int numOfRoom = 10;
      
      switch(1){
        case 1:
        System.out.println("We have 10 rooms available");
        break;
        case 2:
        System.out.println("We have 9 rooms available");
        break;
        case 3:
        System.out.println("We have 8 rooms available");
        break;
        case 4:
        System.out.println("We have 7 rooms available");
        break;
        case 5:
        System.out.println("We have 6 rooms available");
        break;
        case 6:
        System.out.println("We have 5 rooms available");
        break;
        case 7:
        System.out.println("We have 4 rooms available");
        break;
        case 8:
        System.out.println("We have 3 rooms available");
        break;
        case 9:
        System.out.println("We have 2 rooms available");
        break;
        case 10:
        System.out.println("We have 1 room available");
        break;
        default:
        System.out.println("We have no rooms available");
      }
        
  }
 //method to connect to database
 //call at the beginning of the program
  public static Connection getConnection() {
// Load the MySQL JDBC driver
  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println("failed to make connection");
	}
    // connect to the MySQL database on db4free.net
  String url = "jdbc:mysql://db4free.net:3306/hotelsql";
  String username = "rahimisra";
  String password = "kjVw@3dPju8aL5K";
  Connection con = null;
try {
	con = DriverManager.getConnection(url, username, password);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("failed to make connection");
}
  return con;
}
  //method to check if the database is connected
  //useful to test if the database connection has worked
public static boolean testDatabaseconnection(Connection con) {
    boolean isconected = false;
    try {
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT 1");

    if (rs.next()) {
      isconected = true;
    }

    rs.close();
    stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("failed to connect to database server");
    }
    return isconected;
}
  public static void makeAccount(Connection con, String name, String password, String email, String phone, String username) {
	String SQL = "INSERT INTO User_Info(Name, Password, Email, Phone, Username) Values(?,?,?,?,?)";
	try {
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1, name);
    pstmt.setString(2, password);
    pstmt.setString(3, email);
    pstmt.setString(4,  phone);
    pstmt.setString(5,  username);
    pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to make an account");
	}
} 
  public static void updateName(Connection con, String name, String username) {
	String SQL = "UPDATE User_Info SET Name = ? WHERE Username = ?";
	try {
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1, name);
    pstmt.setString(2, username);
    pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to update account name");
	}
} 
  public static void updatePassword(Connection con, String password, String username) {
	String SQL = "UPDATE User_Info SET Password = ? WHERE Username = ?";
	try {
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1, password);
    pstmt.setString(2, username);
    pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to update account password");
	}
} 
  public static void updateEmail(Connection con, String email, String username) {
	String SQL = "UPDATE User_Info SET Email = ? WHERE Username = ?";
	try {
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1, email);
    pstmt.setString(2, username);
    pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to update account email");
	}
} 
  public static void updatePhone(Connection con, String phone, String username) {
	String SQL = "UPDATE User_Info SET Email = ? WHERE Username = ?";
	try {
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1, phone);
    pstmt.setString(2, username);
    pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to update account phone");
	}
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
