import java.sql.Connection;

public class ChangePassword extends DatabaseMethods{
	public void createUser(Connection con, UserInfo user, String username, String password) {
		user.setName(getUser_Name(con, username));
        user.setUsername(username);
        user.setEmail(getUser_Email(con, username));
        user.setPhone(getUser_Phone(con, username));
        user.setPassword(password);
	
	updateAccount(con, user.getName(), user.getPassword(), user.getEmail(), user.getPhone(), user.getUsername());
	}
}
