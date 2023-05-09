import java.util.Random;

public class UserInfo {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private boolean isAdmin = false;
	private String correctAdminPassword = "12345";

	Random random = new Random();

	public UserInfo(String firstName, String lastName, String email, String password, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isAdmin = false;
	}

	public void User(String email, String password) {
		this.email = email;
		this.password = password;
		this.isAdmin = false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(String adminPassword) {
		if (adminPassword == correctAdminPassword) {
			this.isAdmin = true;
		}
	}
}
