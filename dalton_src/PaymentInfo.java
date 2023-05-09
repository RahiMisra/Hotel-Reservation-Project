
public class PaymentInfo {

	private String cardName;
	private String cardNumber;
	private String expirationDate;
	private String CVC;
	private String billingAddress;
	private String shippingAddress;

	public PaymentInfo(String cardName, String cardNumber, String CVC, String expirationDate, String billingAddress,
			String shippingAddress) {
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.CVC = CVC;
		this.expirationDate = expirationDate;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String CVC) {
		this.CVC = CVC;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
