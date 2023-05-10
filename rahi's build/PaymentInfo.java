/**
 * 
 * The PaymentInfo class represents the payment information of a customer.
 * 
 * It contains the card name, card number, CVC, expiration date, billing
 * address, and shipping address.
 */
public class PaymentInfo {

	private String username; //connects payment into with user account
	private String cardName; // The name on the card
	private String cardNumber; // The card number
	private String expirationDate; // The expiration date of the card
	private String CVC; // The CVC number on the card
	private String billingAddress; // The billing address of the customer
	private String shippingAddress; // The shipping address of the customer

	/**
	 * 
	 * Creates a new PaymentInfo object with the specified information.
	 * 
	 * @param cardName        The name on the card
	 * @param cardNumber      The card number
	 * @param CVC             The CVC number on the card
	 * @param expirationDate  The expiration date of the card
	 * @param billingAddress  The billing address of the customer
	 * @param shippingAddress The shipping address of the customer
	 */
	public PaymentInfo(String username, String cardName, String cardNumber, String CVC, String expirationDate, String billingAddress,
			String shippingAddress) {
		this.username = username;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.CVC = CVC;
		this.expirationDate = expirationDate;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}
	
	/**
	 * 
	 * Returns the username attached to the payment
	 * 
	 * @return The username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * Returns the name on the card.
	 * 
	 * @return The name on the card
	 */
	public String getCardName() {
		return cardName;
	}

	/**
	 * 
	 * Returns the card number.
	 * 
	 * @return The card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * 
	 * Returns the CVC number on the card.
	 * 
	 * @return The CVC number on the card
	 */
	public String getCVC() {
		return CVC;
	}

	/**
	 * 
	 * Returns the expiration date of the card.
	 * 
	 * @return The expiration date of the card
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * 
	 * Returns the billing address of the customer.
	 * 
	 * @return The billing address of the customer
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * 
	 * Returns the shipping address of the customer.
	 * 
	 * @return The shipping address of the customer
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	/**
	 * 
	 * Updates the username attached to the payment
	 * 
	 * @param username the new username attached to the payment account
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * Updates the name on the card.
	 * 
	 * @param cardName The new name on the card
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	/**
	 * 
	 * Updates the card number.
	 * 
	 * @param cardNumber The new card number
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public void setCVC(String CVC) {
		this.CVC = CVC;
	}

	/**
	 * 
	 * Updates the expiration date of the card.
	 * 
	 * @param expirationDate The new expiration date of the card
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * 
	 * Updates the billing address of the customer.
	 * 
	 * @param billingAddress The new billing address of the customer
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * 
	 * Updates the shipping address of the customer.
	 * 
	 * @param shippingAddress The new shipping address of the customer
	 */

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
