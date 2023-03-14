import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMethods {
	public static Connection getConnection() {
	    // Load the MySQL JDBC driver
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failure1");
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
		System.out.println("failure2");
	}
	  return con;
	}
	//method to check if the database is connected
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
	      System.out.println("failure2");
	    }
	    return isconected;
	}
	
	
	
	
	
	//User_Account
//---------------------------------------------------------------------------------------------------------------

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

	public static void updateAccount(Connection con, String name, String password, String email, String phone, String username) {
		String SQL = "UPDATE User_Info SET Name = ?, Password = ?, Email = ?, Phone = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, name);
	    pstmt.setString(2, password);
	    pstmt.setString(3, email);
	    pstmt.setString(4, phone);
	    pstmt.setString(5, username);
	    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account");
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
	
	
	
	
	
	//Payment_Account
//---------------------------------------------------------------------------------------------------------------
	public static void makePaymentAccount(Connection con, String name, int paytype, String cardnum, int ccv, String expdate, String country, String address, String username) {
		String SQL = "INSERT INTO Payment_Info(Name, PayType, CardNum, CCV, ExpDate, Country, Address, Username) Values(?,?,?,?,?,?,?,?)";
		try {
		    PreparedStatement pstmt = con.prepareStatement(SQL);
		    pstmt.setString(1, name);
		    pstmt.setInt(2, paytype);
		    pstmt.setString(3, cardnum);
		    pstmt.setInt(4, ccv);
		    pstmt.setString(5, expdate);
		    pstmt.setString(6, country);
		    pstmt.setString(7, address);
		    pstmt.setString(8, username);
		    pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed to create payment account");
			}
		} 
	
	public static void updatePaymentAccount(Connection con, String name, int paytype, String cardnum, int ccv, String expdate, String country, String address, String username) {
		String SQL = "UPDATE Payment_Info SET Name = ?, PayType = ?, CardNum = ?, CCV = ?, ExpDate = ?, Country = ?, Address = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, name);
	    pstmt.setInt(2, paytype);
	    pstmt.setString(3, cardnum);
	    pstmt.setInt(4, ccv);
	    pstmt.setString(5, expdate);
	    pstmt.setString(6, country);
	    pstmt.setString(7, address);
	    pstmt.setString(8, username);
	    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update payment account");
		}
	} 
	
	
	
	
	
	//Reservations
//---------------------------------------------------------------------------------------------------------------
	public static void makeReservation(Connection con, int room, String date, int price, String username) {
		String SQL = "INSERT INTO Reservation(Room, Date, Price, Username) Values(?,?,?,?)";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, room);
	    pstmt.setString(2, date);
	    pstmt.setInt(3, price);
	    pstmt.setString(4,  username);
	    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to make a reservation");
		}
	} 
	
	public static void updateReservation(Connection con, int room, String date, int price, String username) {
		String SQL = "UPDATE Reservation SET Name = ?, Password = ?, Email = ?, Phone = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, room);
	    pstmt.setString(2, date);
	    pstmt.setInt(3, price);
	    pstmt.setString(4,  username);
	    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update reservation");
		}
	} 
	
	//Rooms
//---------------------------------------------------------------------------------------------------------------
	public static void addRoom(Connection con, int room, int floor, int bedrooms, int bathrooms, int beds, int bedsize, int price) {
		String SQL = "INSERT INTO Rooms(Room, Floor, Bedrooms, Bathrooms, Beds, BedSize, Price) Values(?,?,?,?,?,?,?)";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, room);
	    pstmt.setInt(2, floor);
	    pstmt.setInt(3, bedrooms);
	    pstmt.setInt(4, bathrooms);
	    pstmt.setInt(5, beds);
	    pstmt.setInt(6, bedsize);
	    pstmt.setInt(7, price);
	    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to add a room");
		}
	} 
	
	public static void updateRoomPrice(Connection con, int room, int price) {
		String SQL = "UPDATE Reservation SET Price = ? WHERE Room = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, price);
	    pstmt.setInt(2, room);
	    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update price of room");
		}
	} 
	
}
	