package application;

public class Customer {
	
	private int customerID = 0;
	private String customerName = "Default";
	private String address = "Default";
	private String number = "Default";

	public Customer() {
	}
	/**
	 * 
	 * @param customerID
	 * @param customerName
	 * @param address
	 * @param number
	 * Initializes the customer class 
	 */
	public Customer(int customerID, String customerName, String address, String number) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.number = number;
	}
	/**
	 * 
	 * @returns the current customer's id.
	 */
	public int getID() {
	return customerID;
	}
	/**
	 * Changes the current customer ID to the given int orderID.
	 * @param orderID
	 */
	public void setID(int orderID) {
		this.customerID = orderID;
	}
	
	/**
	 * 
	 * @returns the current customer's name.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * Changes the current customers name to the given String customerName
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 
	 * @returns the current customer's address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Changes the current customer's address to the given String address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 
	 * @returns the current customer's phone number.
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * Changes the current customer's phone number to the given String number.
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
}
