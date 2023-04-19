import java.sql.Connection;
/**
 * Login saves your username and password locally and then finds the rest of your information if you have an account in the database
 * @param connection
 * @param user object
 * @param username
 * @param password
 * @return name
 * @return email
 * @return phone number
 * @author Rahi Misra
 */
public class Login extends DatabaseMethods{
	public void userLogin(Connection con, UserInfo user, String username, String password) {
        //save info locally
        user.setUsername(username);
        user.setPassword(password);
        
        //check if account exists and passwords match
        boolean loggedin = user.getPassword().equals(getUser_Password(con, username));
        if (loggedin) {
        	user.setName(getUser_Name(con, username));
        	user.setEmail(getUser_Email(con, username));
        	user.setPhone(getUser_Phone(con, username));
        }
        else {
        	user.setUsername(null);
        	user.setPassword(null);
        }
    }
}
