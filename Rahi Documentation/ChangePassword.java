import java.sql.Connection;
/**
 * lostPassword edits password associated with a specific username locally and then in the database
 * @param connection
 * @param user object
 * @param username
 * @param password
 * @author Rahi Misra
 * 4/10/23
 */
public class ChangePassword extends DatabaseMethods{
	public void lostPassword(Connection con, UserInfo user, String username, String password) {
		user.setName(getUser_Name(con, username));
        user.setUsername(username);
        user.setEmail(getUser_Email(con, username));
        user.setPhone(getUser_Phone(con, username));
        user.setPassword(password);
	
	updateAccount(con, user.getName(), user.getPassword(), user.getEmail(), user.getPhone(), user.getUsername());
	}
}
