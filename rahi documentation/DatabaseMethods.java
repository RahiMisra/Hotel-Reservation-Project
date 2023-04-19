
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *  The DatabaseMethods class contains all of the methods that access the online database
 *  Other sections of the program can call these functions to store the local data online for later use
 *  @author Rahi Misra
 */
public class DatabaseMethods {
	//the get connection function is used to connect to the database server
	//it is necessary to call this at the beginning of the program if using a database
	/**
	 * getConnection connects to the online database and is called at the beginning of the program
	 * @author Rahi Misra
	 */
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
	/**
	 * testDatabaseconnection tests to see if the program could connect to the online database
	 * @author Rahi Misra
	 */
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
	/**
	 * makeAccount makes a new row in the database User_Account table
	 * @param connection
	 * @param name
	 * @param password
	 * @param email
	 * @param phone
	 * @param username
	 * @author Rahi Misra
	 */
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
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to make an account");
		}
	} 
	//this function allows you to update all of the columns in a row
	//requires user's username
	/**
	 * updateAccount edits a row in the database User_Account table where a unique username is found
	 * @param connection
	 * @param name
	 * @param password
	 * @param email
	 * @param phone
	 * @param username
	 * @author Rahi Misra
	 */
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
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account");
		}
	} 
	//this function updates the name in the User_Info table
	//requires user's username
	//this function allows you to update all of the columns in a row
		//requires user's username
		/**
		 * updateName edits a name in the database User_Account table where a unique username is found
		 * @param connection
		 * @param name
		 * @param username
		 * @author Rahi Misra
		 */
	public static void updateName(Connection con, String name, String username) {
		String SQL = "UPDATE User_Info SET Name = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, name);
	    pstmt.setString(2, username);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account name");
		}
	} 
	//this function allows you to update the password in the User_Info table
	//requires user's username
	/**
	 * updatePassword edits a password in the database User_Account table where a unique username is found
	 * @param connection
	 * @param password
	 * @param username
	 * @author Rahi Misra
	 */
	public static void updatePassword(Connection con, String password, String username) {
		String SQL = "UPDATE User_Info SET Password = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, password);
	    pstmt.setString(2, username);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account password");
		}
	} 
	//this function allows you to update the email in the User_Info table
	//requires user's username
	/**
	 * updateEmail edits an email in the database User_Account table where a unique username is found
	 * @param connection
	 * @param email
	 * @param username
	 * @author Rahi Misra
	 */
	public static void updateEmail(Connection con, String email, String username) {
		String SQL = "UPDATE User_Info SET Email = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, email);
	    pstmt.setString(2, username);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account email");
		}
	} 
	//this function allows you to update the phone number in the User_Info table
	//requires user's username
	/**
	 * updatePhone edits a phone number in the database User_Account table where a unique username is found
	 * @param connection
	 * @param phone
	 * @param username
	 * @author Rahi Misra
	 */
	public static void updatePhone(Connection con, String phone, String username) {
		String SQL = "UPDATE User_Info SET Phone = ? WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, phone);
	    pstmt.setString(2, username);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update account phone");
		}
	} 
	
	
	
	
	
	//Payment_Account	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to make a row in the Payment_Info table
	/**
	 * makePaymentAccount makes a new row in the database Payment_Account table
	 * @param connection
	 * @param name
	 * @param payment type
	 * @param card number
	 * @param ccv
	 * @param card expiration date
	 * @param country
	 * @param address
	 * @param username
	 * @author Rahi Misra
	 */
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
		    pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("failed to create payment account");
			}
		} 
	//this function allows you to update a row in the Payment_Info table
	//requires user's username
	/**
	 * updatePaymentAccount makes a new row in the database Payment_Account table
	 * @param connection
	 * @param name
	 * @param payment type
	 * @param card number
	 * @param ccv
	 * @param card expiration date
	 * @param country
	 * @param address
	 * @param username
	 * @author Rahi Misra
	 */
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
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update payment account");
		}
	} 
	
	
	
	
	
	//Reservations	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to make a row in the Reservation table
	/**
	 * makeReservation makes a new row in the database Reservation table
	 * @param connection
	 * @param room
	 * @param date
	 * @param price
	 * @param username
	 * @author Rahi Misra
	 */
	public static void makeReservation(Connection con, int room, String date, int price, String username) {
		String SQL = "INSERT INTO Reservation(Room, Date, Price, Username) Values(?,?,?,?)";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, room);
	    pstmt.setString(2, date);
	    pstmt.setInt(3, price);
	    pstmt.setString(4,  username);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to make a reservation");
		}
	} 
	//this function allows you to update the room column the Reservation table
	//requires reservation's room and date
	/**
	 * updateReservationRoom allows you to edit any room number on a reservation if you have the room number and date of the reservation
	 * @param connection
	 * @param room number
	 * @param date
	 * @param newroom
	 * @author Rahi Misra
	 */
	public static void updateReservationRoom(Connection con, int room, String date, int newroom) {
		String SQL = "UPDATE Reservation SET Room = ? WHERE Room = ? AND Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, newroom);
	    pstmt.setInt(2, room);
	    pstmt.setString(3,  date);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update reservation room");
		}
	} 
	//this function allows you to update the date column in the Reservation table
	//requires reservation's room and date
	/**
	 * updateReservationRoom allows you to edit any date on a reservation if you have the room number and date of the reservation
	 * @param connection
	 * @param room number
	 * @param date
	 * @param newdate
	 * @author Rahi Misra
	 */
	public static void updateReservationDate(Connection con, int room, String date, String newdate) {
		String SQL = "UPDATE Reservation SET Date = ? WHERE Room = ? AND Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1, newdate);
	    pstmt.setInt(2, room);
	    pstmt.setString(3,  date);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update reservation date");
		}
	} 
	//this function allows you to update the price column in the Reservation table
	//requires reservation's room and date
	/**
	 * updateReservationRoom allows you to edit any price on a reservation if you have the room number and date of the reservation
	 * @param connection
	 * @param room number
	 * @param date
	 * @param price
	 * @author Rahi Misra
	 */
	public static void updateReservationPrice(Connection con, int room, String date, int price) {
		String SQL = "UPDATE Reservation SET Price = ? WHERE Room = ? AND Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, price);
	    pstmt.setInt(2, room);
	    pstmt.setString(3,  date);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update reservation price");
		}
	} 
	
	
	
	
	
	//Rooms	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to make a row in the Rooms table
	/**
	 * addRoom makes a new row in the database Rooms table
	 * @param connection
	 * @param room number
	 * @param floor number
	 * @param number of bedrooms
	 * @param number of bathrooms
	 * @param number of beds
	 * @param size of beds
	 * @param price
	 * @author Rahi Misra
	 */
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
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to add a room");
		}
	} 
	//this function allows you to update the price of a room
	//requires the room number
	/**
	 * updateRoomPrice changes the price of a room in the Rooms table
	 * @param connection
	 * @param room number
	 * @param price
	 * @author Rahi Misra
	 */
	public static void updateRoomPrice(Connection con, int room, int price) {
		String SQL = "UPDATE Rooms SET Price = ? WHERE Room = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1, price);
	    pstmt.setInt(2, room);
	    pstmt.executeUpdate();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update price of room");
		}
	} 
	
	
	
	
	
	
	
	
	
	
	
//---------------------------------------------------------------------------------------------------------------
//accessing data
//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//User_Account	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get the name from the User_Info table
	//requires the user's username
	/**
	 * getUser_Name gets you the name of the user associated with a username
	 * @param connection
	 * @param username
	 * @return name
	 * @author Rahi Misra
	 */
	public static String getUser_Name(Connection con, String username) {
		String gotName = null;
		String SQL = "SELECT Name FROM User_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotName = rs.getString("Name");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get name");
		}
		return gotName;
	} 
	//this function allows you to get the password from the User_Info table
	//requires the user's username
	/**
	 * getUser_Password gets you the password of the user associated with a username
	 * @param connection
	 * @param username
	 * @return password
	 * @author Rahi Misra
	 */
	public static String getUser_Password(Connection con, String username) {
		String gotPassword = null;
		String SQL = "SELECT Password FROM User_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotPassword = rs.getString("Password");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get password");
		}
		return gotPassword;
	} 
	//this function allows you to get the email from the User_Info table
	//requires the user's username
	/**
	 * getUser_Email gets you the email of the user associated with a username
	 * @param connection
	 * @param username
	 * @return email
	 * @author Rahi Misra
	 */
	public static String getUser_Email(Connection con, String username) {
		String gotEmail = null;
		String SQL = "SELECT Email FROM User_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotEmail = rs.getString("Email");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get email");
		}
		return gotEmail;
	} 
	//this function allows you to get the phone number from the User_Info table
	//requires the user's username
	/**
	 * getUser_Phone gets you the phone number of the user associated with a username
	 * @param connection
	 * @param username
	 * @return phone number
	 * @author Rahi Misra
	 */
	public static String getUser_Phone(Connection con, String username) {
		String gotPhone = null;
		String SQL = "SELECT Phone FROM User_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotPhone = rs.getString("Phone");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get phone");
		}
		return gotPhone;
	} 
	
	
	
	
	
	//Payment Account	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get the name from the Payment_Info table
	//requires the user's username
	/**
	 * getPayment_Name gets you the name associated with a specific username
	 * @param connection
	 * @param username
	 * @return name
	 * @author Rahi Misra
	 */
	public static String getPayment_Name(Connection con, String username) {
		String gotName = null;
		String SQL = "SELECT Name FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotName = rs.getString("Name");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get name");
		}
		return gotName;
	} 
	//this function allows you to get the payment type from the Payment_Info table
		//requires the user's username
	/**
	 * getPayment_Type gets you the type of payment associated with the account under a specific username
	 * @param connection
	 * @param username
	 * @return payment type
	 * @author Rahi Misra
	 */
	public static int getPayment_Type(Connection con, String username) {
		int gotPayType = 0;
		String SQL = "SELECT PayType FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotPayType = rs.getInt("PayType");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get payment type");
		}
		return gotPayType;
	}
	//this function allows you to get the card number from the Payment_Info table
	//requires the user's username
	/**
	 * getPayment_Card gets you the card number associated with the account under a specific username
	 * @param connection
	 * @param username
	 * @return card number
	 * @author Rahi Misra
	 */
	public static String getPayment_Card(Connection con, String username) {
		String gotCard = null;
		String SQL = "SELECT CardNum FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotCard = rs.getString("CardNum");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get name");
		}
		return gotCard;
	} 
	//this function allows you to get the ccv from the Payment_Info table
	//requires the user's username
	/**
	 * getCCV gets you the card ccv associated with the account under a specific username
	 * @param connection
	 * @param username
	 * @return card ccv
	 * @author Rahi Misra
	 */
	public static int getCCV(Connection con, String username) {
		int gotCCV = 0;
		String SQL = "SELECT CCV FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotCCV = rs.getInt("CCV");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get ccv");
		}
		return gotCCV;
	} 
	//this function allows you to get the expiration date from the Payment_Info table
	//requires the user's username
	/**
	 * getPayment_ExpDate gets you the expirating date of the card associated with the account under a specific username
	 * @param connection
	 * @param username
	 * @return card expiration date
	 * @author Rahi Misra
	 */
	public static String getPayment_ExpDate(Connection con, String username) {
		String gotExp = null;
		String SQL = "SELECT ExpDate FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotExp = rs.getString("ExpDate");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get card expiration date");
		}
		return gotExp;
	} 
	//this function allows you to get the country from the Payment_Info table
	//requires the user's username
	/**
	 * getPayment_Country gets you the country the user lives in
	 * @param connection
	 * @param username
	 * @return country
	 * @author Rahi Misra
	 */
	public static String getPayment_Country(Connection con, String username) {
		String gotCountry = null;
		String SQL = "SELECT Country FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotCountry = rs.getString("Country");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get country of residence");
		}
		return gotCountry;
	} 
	//this function allows you to get the address from the Payment_Info table
	//requires the user's username
	/**
	 * getPayment_Country gets you the addressof the user
	 * @param connection
	 * @param username
	 * @return user address
	 * @author Rahi Misra
	 */
	public static String getPayment_Address(Connection con, String username) {
		String gotAddress = null;
		String SQL = "SELECT Address FROM Payment_Info WHERE Username = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotAddress = rs.getString("Address");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get address");
		}
		return gotAddress;
	} 
	
	
	
	
	
	//Reservations	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get the username associated with a reservation from the Reservation table
	//requires the reservation's room number and date
	/**
	 * getReservation_Username gets you the username associated with a specific reservation
	 * @param connection
	 * @param room
	 * @param date
	 * @return username
	 * @author Rahi Misra
	 */
	public static String getReservation_Username(Connection con, int room, String date) {
		String gotUsername = null;
		String SQL = "SELECT Username FROM Reservation WHERE Room = ? AND Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1,  room);
	    pstmt.setString(2,  date);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotUsername = rs.getString("Username");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get reservation");
		}
		return gotUsername;
	}
	//this function allows you to get the price associated with a reservation from the Reservation table
	//requires the reservation's room number and date
	/**
	 * getReservation_Price gets you the price associated with a specific reservation
	 * @param connection
	 * @param room
	 * @param date
	 * @return price
	 * @author Rahi Misra
	 */
	public static int getReservation_Price(Connection con, int room, String date) {
		int gotPrice = 0;
		String SQL = "SELECT Price FROM Reservation WHERE Room = ? AND Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1,  room);
	    pstmt.setString(2,  date);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotPrice = rs.getInt("Price");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get reservation price");
		}
		return gotPrice;
	}
	
	
	
	
	
	//Rooms	(working)
//---------------------------------------------------------------------------------------------------------------
	//this function allows you to get a room object from the Rooms table
	//requires the room number
	/**
	 * getRoom gets you all of the info from a room in the database
	 * puts all the info into a room object for local use
	 * @param connection
	 * @param room
	 * @return room number
	 * @return floor number
	 * @return number of bedrooms
	 * @return number of bathrooms
	 * @return number of beds
	 * @return size of beds
	 * @return price
	 * @author Rahi Misra
	 */
	public static Room getRoom(Connection con, int room) {
		Room gotRoom = new Room();
		String SQL = "SELECT * FROM Rooms WHERE Room = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setInt(1,  room);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotRoom.room = rs.getInt("Room");
	    	gotRoom.floor = rs.getInt("Floor");
	    	gotRoom.bedrooms = rs.getInt("Bedrooms");
	    	gotRoom.bathrooms = rs.getInt("Bathrooms");
	    	gotRoom.beds = rs.getInt("Beds");
	    	gotRoom.bedsize = rs.getInt("BedSize");
	    	gotRoom.price = rs.getInt("Price");
	    	gotRoom.room = rs.getInt("Room");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get room");
		}
		return gotRoom;
	}











//---------------------------------------------------------------------------------------------------------------
//deletion
//---------------------------------------------------------------------------------------------------------------
	
	
	
	

	//User Info	(working)
//---------------------------------------------------------------------------------------------------------------
//this function allows you to delete a row from the User_Info table
//requires the user's username
	/**
	 * deleteUser deletes a row from the User_Info table in the online database
	 * @param connection
	 * @param username
	 * @author Rahi Misra
	 */
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
/**
 * deleteUser deletes a row from the Payment_Info table in the online database
 * @param connection
 * @param username
 * @author Rahi Misra
 */
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
/**
 * deleteUser deletes a row from the Reservation table in the online database
 * @param connection
 * @param room number
 * @param date
 * @author Rahi Misra
 */
public static void deleteReservation(Connection con, int room, String date) {
	String SQL = "DELETE FROM Reservation WHERE Room = ? AND Date = ?";
	try {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1,  room);
		pstmt.setString(2,  date);
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
/**
 * deleteUser deletes a row from the Rooms table in the online database
 * @param connection
 * @param room number
 * @author Rahi Misra
 */
public static void deleteRoom(Connection con, int room) {
	String SQL = "DELETE FROM Rooms WHERE Room = ?";
	try {
		PreparedStatement pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1,  room);
		pstmt.executeUpdate();
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("failed to delete room");
	}
}

}