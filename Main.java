import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;


class Main extends DatabaseMethods {
	
	
  public static void main(String[] args) {
  Connection con = getConnection();
   //check if the database connects
  if (testDatabaseconnection(con)) {
    System.out.println("Database connection successful!");
  }
  else {
    System.out.println("Database connection failed.");
  }
  	GUI gui = new GUI(con);

    System.out.println("Hello world!");
  }
}
