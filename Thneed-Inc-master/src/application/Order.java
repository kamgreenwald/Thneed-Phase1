package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private int orderID = 0;
	private String thneeds = "Default";
	private String customerName = "Unknown";
	private LocalDate orderDate = LocalDate.now();
	private LocalDate filledDate = LocalDate.now();

	public Order() {
	}
	/**
	 * 
	 * @param orderID int
	 * @param thneeds String
	 * @param customerName String
	 * @param orderDate LocalDate
	 * @param filledDate LocalDate
	 * initializes the order classwith 5 parameters and 
	 * assigns them to the current instances variables
	 */
	public Order(int orderID, String thneeds, String customerName, LocalDate orderDate, LocalDate filledDate) {
		this.orderID = orderID;
		this.thneeds = thneeds;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.filledDate = filledDate;
		
	}
	/**
	 * 
	 * @return current instance of Order's id.
	 */
	public int getID() {
	return orderID;
	}
	/**
	 * Changes current instance of orderID to the given int orderID.
	 * @param orderID int
	 */
	public void setID(int orderID) {
		this.orderID = orderID;
	}
	/**
	 * 
	 * @return current instance of thneeds.
	 */
	public String getThneeds() {
		return thneeds;
	}
	/**
	 * Sets current instance of thneeds to given parameter String thneeds
	 * @param thneeds
	 */
	public void setThneeds(String thneeds) {
		this.thneeds = thneeds;
	}
	/**
	 * 
	 * @return current instance of customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * Sets current customer name to given parameter customerName.
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 
	 * @return current instance of orderDate.
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}
	/**
	 * changes current instance of orderDate with given variable LocalDate orderDate.
	 * @param orderDate
	 */
	public void setOrderDate(LocalDate orderDate) {
		
		this.orderDate = orderDate;
	}
	/**
	 * 
	 * @return
	 */
	public LocalDate getFillDate() {
		return filledDate;
	}
	/**
	 * 
	 * @param filledDate
	 */
	public void setFilledDate(LocalDate filledDate) {
		this.filledDate = filledDate;
	}
	
	@Override
	public String toString() {
		return "Customer: " + this.getCustomerName() + " ,Thneeds: " + this.getThneeds() + " ,Date Ordered:" + this.getOrderDate() + " ,Date Filled:" + this.getFillDate();
	}
	
}
