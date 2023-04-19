
public class Logout {
	public void userLogout(UserInfo user) {
		user.setUsername(null);
        user.setPassword(null);
        user.setName(null);
    	user.setEmail(null);
    	user.setPhone(null);
	}
}
