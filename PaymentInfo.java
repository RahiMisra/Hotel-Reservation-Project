public class PaymentInfo {

	private String cardName;
	private String cardNumber;
	private int expirationMonth;
	private int expirationYear;
	private String billingAddress;
	private String shippingAddress;

	public PaymentInfo(String cardName, String cardNumber, int expirationMonth, int expirationYear,
			String billingAddress, String shippingAddress) {
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public String getCardName() {
		return cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	// Optional setters if you need to update the payment info later
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
