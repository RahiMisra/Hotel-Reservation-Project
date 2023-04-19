import java.sql.Connection;
import java.sql.SQLException;


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
