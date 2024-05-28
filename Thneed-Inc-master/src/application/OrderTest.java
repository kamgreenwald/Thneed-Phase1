package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
	/**
	 * 
	 * @author blabe
	 *
	 */
public class OrderTest {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	Order test = new Order(0,"45", "Bob Man",LocalDate.now(), LocalDate.now());
	@Test
	public void testGetID() {
		Assert.assertEquals(0, test.getID());
	}

	@Test
	public void testSetID() {
		test.setID(10);
		Assert.assertEquals(10, test.getID());
	}

	@Test
	public void testGetThneeds() {
		Assert.assertEquals("45", test.getThneeds());
	}

	@Test
	public void testSetThneeds() {
		test.setThneeds("522");
		Assert.assertEquals("522", test.getThneeds());
	}

	@Test
	public void testGetCustomerName() {
		Assert.assertEquals("Bob Man", test.getCustomerName());
	}

	@Test
	public void testSetCustomerName() {
		test.setCustomerName("Billy Man");
		Assert.assertEquals("Billy Man", test.getCustomerName());
	}

	@Test
	public void testGetOrderDate() {
		Assert.assertEquals("2024-04-05", test.getOrderDate().toString());
	}

	@Test
	public void testSetOrderDate() {
		Assert.assertEquals("2023-11-05", test.getOrderDate().minusMonths(5).toString());
	}

	@Test
	public void testGetFillDate() {
		Assert.assertEquals("2024-04-05", test.getFillDate().toString());
	}

	@Test
	public void testSetFilledDate() {
		test.setFilledDate(test.getOrderDate().plusDays(2));
		Assert.assertEquals("2024-04-07", test.getFillDate().toString() );
	}
	Order test1 = new Order(0,"45", "Bob Man",LocalDate.now(), LocalDate.now().plusDays(2));
	@Test
	public void testToString() {
		Assert.assertEquals("Customer: Bob Man ,Thneeds: 45 ,Date Ordered:2024-04-05 ,Date Filled:2024-04-07", test1.toString());
	}

}
