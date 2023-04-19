import java.sql.Connection;
import java.sql.SQLException;

/**
 * the main file is the basis from which all of the other functions launch
 * @author Rahi Misra
 * 4/17/23
 */
class Main extends DatabaseMethods {
	
	UserInfo user = new UserInfo();
	public boolean LoggedIn;
	
	
  public static void main(String[] args) {
  Connection con = getConnection();
   //check if the database connects
  if (testDatabaseconnection(con)) {
    System.out.println("Database connection successful!");
  }
  else {
    System.out.println("Database connection failed.");
  }
	
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("failure3");
	}
    System.out.println("Hello world!");
  }
}
