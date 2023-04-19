/**
 * Logout sets the local user object to null
 * @param user object
 * @author Rahi Misra
 * 4/17/23
 */
public class Logout {
	public void userLogout(UserInfo user) {
		user.setUsername(null);
        user.setPassword(null);
        user.setName(null);
    	user.setEmail(null);
    	user.setPhone(null);
	}
}
