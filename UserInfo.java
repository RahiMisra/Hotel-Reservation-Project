import java.util.Random;

public class UserInfo {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int accountNumber;
	private boolean isAdmin;

	public void User(String firstName, String lastName, String email, String password, int accountNumber,
			boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accountNumber = accountNumber;
		this.isAdmin = isAdmin;
		// set a unique account number of 9 digits, and doesn't match with any other
		// preexisting account
		// quick search all the other account information to make sure it doesn't match
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

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber() {
		Random random = new Random();
		this.accountNumber = random.nextInt(999999999 - 100000000 + 1) + 100000000;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
