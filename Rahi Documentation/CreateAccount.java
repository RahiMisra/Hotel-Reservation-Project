import java.sql.Connection;
/**
 * createUser creates a user object locally then stores that information into the User_Info table in the database
 * @param connection
 * @param user object
 * @param name
 * @param username
 * @param email
 * @param phone number
 * @param password
 * @author Rahi Misra
 * 3/8/23
 */
public class CreateAccount extends DatabaseMethods{
	public void createUser(Connection con, UserInfo user, String name, String username, String email, String phone, String password) {
        //save info locally
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        
        //put info onto database
        makeAccount(con, user.getName(), user.getPassword(), user.getEmail(), user.getPhone(), user.getUsername());
    }
}
