
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class DatabaseMethods {
	//the get connection function is used to connect to the database server
	//it is necessary to call this at the beginning of the program if using a database
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
	//function to check if the database is connected
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
	      System.out.println("failure3");
	    }
	    return isconected;
	}
	
	
	
	
	
	
	
	
	
	
	
//---------------------------------------------------------------------------------------------------------------
//Creating table entries
//Updating table entries
//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//User_Account (working)
//---------------------------------------------------------------------------------------------------------------
	//this function makes a row in the User_Info table
	//retested
	public static void makeAccount(Connection con, UserInfo user) {
		String SQL = "INSERT INTO User_Info(Name, Password, Email, Phone, Admin, Username) Values(?,?,?,?,?,?)";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, user.getName());
	    pstmt.setString(2, user.getPassword());
	    pstmt.setString(3, user.getEmail());
	    pstmt.setString(4,  user.getPhoneNumber());
	    pstmt.setInt(5, user.getAdmin());
	    pstmt.setString(6,  user.getUsername());
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to make an account");
		}
	} 
	//this function allows you to update all of the columns in a row
	//requires user's username
	//retested
	public static void updateAccount(Connection con, UserInfo user) {
		String SQL = "UPDATE User_Info SET Name = ?, Password = ?, Email = ?, Phone = ?, Admin = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, user.getName());
	    pstmt.setString(2, user.getPassword());
	    pstmt.setString(3, user.getEmail());
	    pstmt.setString(4, user.getPhoneNumber());
	    pstmt.setInt(5, user.getAdmin());
	    pstmt.setString(6, user.getUsername());
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account");
		}
	}

	//Payment_Account	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to make a row in the Payment_Info table
	//retested
	public static void makePaymentAccount(Connection con, PaymentInfo payment) {
		String SQL = "INSERT INTO Payment_Info(Name, CardNum, CCV, ExpDate, Billing, Shipping, Username) Values(?,?,?,?,?,?,?)";
		try {
		    PreparedStatement pstmt = con.prepareStatement(SQL);
		    pstmt.setString(1, payment.getCardName());
		    pstmt.setString(2, payment.getCardNumber());
		    pstmt.setString(3, payment.getCVC());
		    pstmt.setString(4, payment.getExpirationDate());
		    pstmt.setString(5, payment.getBillingAddress());
		    pstmt.setString(6, payment.getShippingAddress());
		    pstmt.setString(7, payment.getUsername());
		    pstmt.executeUpdate();
		    pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed to create payment account");
			}
		} 
	//this function allows you to update a row in the Payment_Info table
	//requires user's username
	//retested
	public static void updatePaymentAccount(Connection con, PaymentInfo payment) {
		String SQL = "UPDATE Payment_Info SET Name = ?, CardNum = ?, CCV = ?, ExpDate = ?, Billing = ?, Shipping = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, payment.getCardName());
	    pstmt.setString(2, payment.getCardNumber());
	    pstmt.setString(3, payment.getCVC());
	    pstmt.setString(4, payment.getExpirationDate());
	    pstmt.setString(5, payment.getBillingAddress());
	    pstmt.setString(6, payment.getShippingAddress());
	    pstmt.setString(7, payment.getUsername());
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update payment account");
		}
	} 
	
	
	
	
	
	//Reservations	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to make a row in the Reservation table
	//retested
	public static void makeReservation(Connection con, Reservation reservation) {
		String SQL = "INSERT INTO Reservation(RoomType, Confirmation, Guests, CheckIn, CheckOut) Values(?,?,?,?,?)";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, reservation.getRoomType());
	    pstmt.setInt(2, reservation.getConfirmationNumber());
	    pstmt.setInt(3, reservation.getGuests());
	    pstmt.setDate(4, Date.valueOf(reservation.getCheckInDate()));
	    pstmt.setDate(5,  Date.valueOf(reservation.getCheckOutDate()));
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to make a reservation");
		}
	} 
	//this function allows you to update the room column the Reservation table
	//requires reservation's room and date
	//probably not needed anymore
	/*
	 * public static void updateReservation(Connection con, Reservation reservation)
	 * { String SQL = "UPDATE Reservation SET Room = ? WHERE Room = ? AND Date = ?";
	 * try { PreparedStatement pstmt = con.prepareStatement(SQL); pstmt.setString(1,
	 * reservation.getRoomType()); pstmt.setInt(2,
	 * reservation.getConfirmationNumber()); pstmt.setInt(3,
	 * reservation.getGuests()); pstmt.setDate(4,
	 * Date.valueOf(reservation.getCheckInDate())); pstmt.setDate(5,
	 * Date.valueOf(reservation.getCheckOutDate())); pstmt.executeUpdate();
	 * pstmt.close(); } catch (SQLException e) { e.printStackTrace();
	 * System.out.println("failed to update reservation"); } }
	 */


	
	
	
	
	
	//Rooms	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to make a row of occupied rooms in the Rooms table
	public static void addRoom(Connection con, int day, AvailableRooms occupied) {
		String SQL = "INSERT INTO Rooms(Day, King, Queen, Suite) Values(?,?,?,?)";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, day);
	    pstmt.setInt(2, occupied.getkingBedsOccupied());
	    pstmt.setInt(3, occupied.getqueenBedsOccupied());
	    pstmt.setInt(4, occupied.getsuiteBedsOccupied());
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to add a room");
		}
	} 
	//this function allows you to update the occupied rooms count
	//requires the room number
	public static void updateRoom(Connection con, int day ,AvailableRooms occupied) {
		String SQL = "UPDATE Rooms SET King = ?, Queen = ?, Suite = ? WHERE Day = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, occupied.getkingBedsOccupied());
	    pstmt.setInt(2, occupied.getqueenBedsOccupied());
	    pstmt.setInt(3, occupied.getsuiteBedsOccupied());
	    pstmt.setInt(4, day);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update avaliable rooms");
		}
	} 
	
	
	
	
	
	
	
	
	
	
	
//---------------------------------------------------------------------------------------------------------------
//accessing data
//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//User_Account	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get the info from the User_Info table
	//requires the user's username
	//retested
	public static void getUser_Info(Connection con, UserInfo user) {
		String gotName = null;
		String gotPass = null;
		String gotEmail = null;
		String gotPhone = null;
		String gotAdmin = null;
		String SQL = "SELECT Name, Password, Email, Phone, Admin FROM User_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  user.getUsername());
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotName = rs.getString("Name");
	    	gotPass = rs.getString("Password");
	    	gotEmail = rs.getString("Email");
	    	gotPhone = rs.getString("Phone");
	    	gotAdmin = rs.getString("Admin");
	    	user.setName(gotName);
	    	user.setPassword(gotPass);
	    	user.setEmail(gotEmail);
	    	user.setPhoneNumber(gotPhone);
	    	user.setAdmin(gotAdmin);
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get user info");
		}
	} 
 
	
	
	
	
	
	//Payment Account	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get info from the Payment_Info table
	//requires the user's username
	//retested
	public static void getPayment_Info(Connection con, PaymentInfo payment) {
		String gotName = null;
		String gotCard = null;
		String gotExp = null;
		String gotCCV = null;
		String gotBilling = null;
		String gotShipping = null;
		String SQL = "SELECT Name, CardNum, CCV, ExpDate, Billing, Shipping FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  payment.getUsername());
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotName = rs.getString("Name");
	    	gotCard = rs.getString("CardNum");
	    	gotCCV = rs.getString("CCV");
	    	gotExp = rs.getString("ExpDate");
	    	gotBilling = rs.getString("Billing");
	    	gotShipping = rs.getString("Shipping");
	    	payment.setCardName(gotName);
	    	payment.setCardNumber(gotCard);
	    	payment.setExpirationDate(gotExp);
	    	payment.setCVC(gotCCV);
	    	payment.setBillingAddress(gotBilling);
	    	payment.setShippingAddress(gotShipping);
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get name");
		}
	} 

	
	
	
	
	
	//Reservations	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get the username associated with a reservation from the Reservation table
	//requires the reservation's room number and date
	public static ArrayList<Reservation> getReservation(Connection con, ArrayList<Reservation> reservationList) {
		String SQL = "SELECT * FROM Reservation"; // Replace with your table name
		try {
		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery(SQL);
		    while (rs.next()) {
		        // Get values from ResultSet and create a Reservation object
		        LocalDate checkInDate = rs.getDate("CheckIn").toLocalDate();
		        LocalDate checkOutDate = rs.getDate("CheckOut").toLocalDate();
		        int totalGuests = rs.getInt("Guests");
		        int confirmationNumber = rs.getInt("Confirmation");
		        String roomType = rs.getString("RoomType");
		        Reservation reservation = new Reservation(checkInDate, checkOutDate, totalGuests, roomType, confirmationNumber);
		        
		        // Add Reservation object to ArrayList
		        reservationList.add(reservation);
		    }
		    rs.close();
		    stmt.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Failed to retrieve reservations from database");
		}
		return reservationList;
	}

	
	
	
	
	
	//Rooms	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get a room object from the Rooms table
	//requires the room number
	public static void getRoom(Connection con, int day, AvailableRooms room) {
		String SQL = "SELECT * FROM Rooms WHERE Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1,  day);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	room.setkingBedsOccupied(rs.getInt("King"));
	    	room.setqueenBedsOccupied(rs.getInt("Queen"));
	    	room.setsuiteBedsOccupied(rs.getInt("Suite"));
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get room");
		}
	}











//---------------------------------------------------------------------------------------------------------------
//deletion
//---------------------------------------------------------------------------------------------------------------
	
	
	
	

	//User Info	(working)
//---------------------------------------------------------------------------------------------------------------
//this function allows you to delete a row from the User_Info table
//requires the user's username
	//refactored & retested
public static void deleteUser(Connection con, String username) {
	String SQL = "DELETE FROM User_Info WHERE Username = ?";
	try {
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1,  username);
    pstmt.executeUpdate();
    pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to delete account");
	}
}	





	//Payment Info	(working)
//---------------------------------------------------------------------------------------------------------------
//this function allows you to delete a row from the Payment_Info table
//requires the user's username
//refactored & retested
public static void deletePayment(Connection con, String username) {
	String SQL = "DELETE FROM Payment_Info WHERE Username = ?";
	try {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,  username);
		pstmt.executeUpdate();
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to delete payment account");
	}
}





	//Reservation	(working)
//---------------------------------------------------------------------------------------------------------------
//this function allows you to delete a row from the Reservation table
//requires the reservation's room number and date
//retested
public static void deleteReservation(Connection con, Reservation reservation) {
	String SQL = "DELETE FROM Reservation WHERE RoomType = ? AND Confirmation = ? AND Guests = ? AND CheckIn = ? AND CheckOut = ?";
	try {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, reservation.getRoomType());
	    pstmt.setInt(2, reservation.getConfirmationNumber());
	    pstmt.setInt(3, reservation.getGuests());
	    pstmt.setDate(4, Date.valueOf(reservation.getCheckInDate()));
	    pstmt.setDate(5,  Date.valueOf(reservation.getCheckOutDate()));
		pstmt.executeUpdate();
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to delete reservation");
	}
}





	//Room	(working)
//---------------------------------------------------------------------------------------------------------------
//this function allows you to delete a row from the Room table
//requires the room number
public static void deleteRoom(Connection con, int date) {
	String SQL = "DELETE FROM Rooms WHERE Date = ?";
	try {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1,  date);
		pstmt.executeUpdate();
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to delete room");
	}
}

}