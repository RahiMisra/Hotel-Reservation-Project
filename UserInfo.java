import java.util.Random;

/**
 * The UserInfo class holds user information that is used to store their own
 * account for the reservation system. Users can input their information and
 * create an account, and if they are an admin they can provide the correct
 * admin password to access additional functionality. This class is used to tie
 * reservations to an account and add a viewReservations ability in the GUI that
 * uses this and reservation.
 */
public class UserInfo {
	/**
	 * 
	 * The first name of the user.
	 */
	private String firstName;
	/**
	 * 
	 * The last name of the user.
	 */
	private String lastName;
	/**
	 * 
	 * The email address of the user.
	 */
	private String email;
	/**
	 * 
	 * The password of the user.
	 */
	private String password;
	/**
	 * 
	 * The phone number of the user.
	 */
	private String phoneNumber;
	/**
	 * 
	 * A boolean indicating whether the user is an admin or not.
	 */
	private boolean isAdmin;
	/**
	 * 
	 * The correct admin password for the system.
	 */
	private String correctAdminPassword = "123password";
	Random random = new Random();

	/**
	 * This method creates a new user account with the provided email and password.
	 * The first name, last name, phone number, and admin status can be set later.
	 *
	 * @param email    a String value representing the user's email
	 * @param password a String value representing the user's password
	 */
	public void User(String email, String password) {
		this.email = email;
		this.password = password;
		this.isAdmin = false;
	}

	/**
	 * This constructor creates a new user account with the provided information.
	 *
	 * @param firstName   a String value representing the user's first name
	 * @param lastName    a String value representing the user's last name
	 * @param email       a String value representing the user's email
	 * @param password    a String value representing the user's password
	 * @param phoneNumber a String value representing the user's phone number
	 */
	public UserInfo(String firstName, String lastName, String email, String password, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isAdmin = false;
	}

	/**
	 * This method returns the user's first name.
	 *
	 * @return a String value representing the user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method sets the user's first name.
	 *
	 * @param firstName a String value representing the user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method returns the user's last name.
	 *
	 * @return a String value representing the user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method sets the user's last name.
	 *
	 * @param lastName a String value representing the user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method returns the user's email address.
	 *
	 * @return a String value representing the user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method sets the user's email address.
	 *
	 * @param email a String value representing the user's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method returns the user's password.
	 *
	 * @return a String value representing the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method sets the user's password.
	 *
	 * @param password a String value representing the user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * Returns the phone number of the user.
	 * 
	 * @return the phone number of the user.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * Sets the phone number of the user.
	 * 
	 * @param phoneNumber the new phone number for the user.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * Returns whether the user is an admin or not.
	 * 
	 * @return true if the user is an admin, false otherwise.
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * 
	 * Sets the admin status of the user by checking the provided admin password.
	 * 
	 * @param adminPassword the password to check for admin status.
	 */
	public void setAdmin(String adminPassword) {
		if (adminPassword == correctAdminPassword) {
			this.isAdmin = true;
		}
	}

}
