package databaseimplementation;
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
		    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
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
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to update price of room");
		}
	} 
	
	
	
	
	
	
	
	
	
	
	
//---------------------------------------------------------------------------------------------------------------
//accessing data
//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//User_Account
//---------------------------------------------------------------------------------------------------------------
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
	
	
	
	
	
	//Payment Account
//---------------------------------------------------------------------------------------------------------------
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
	
	
	
	
	
	//Reservations
//---------------------------------------------------------------------------------------------------------------
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
			System.out.println("failed to get username");
		}
		return gotUsername;
	}
	
	public static int getReservation_Price(Connection con, String username) {
		int gotPrice = 0;
		String SQL = "SELECT Price FROM Reservation WHERE Room = ? AND Date = ?";
		try {
	    PreparedStatement pstmt = con.prepareStatement(SQL);
	    pstmt.setString(1,  username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	gotPrice = rs.getInt("Price");
	    }
	    rs.close();
	    pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("failed to get name");
		}
		return gotPrice;
	}
	
	
	
	
	
	//Rooms
//---------------------------------------------------------------------------------------------------------------
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
			System.out.println("failed to get name");
		}
		return gotRoom;
	}

}
	