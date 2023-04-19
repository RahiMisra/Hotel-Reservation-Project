import java.sql.Connection;

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
