package application;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
	Customer test = new Customer(1,"Zane", "700N N Woodlawn Ave Hall", "948910");

	@Test
	public void testGetID() {
		Assert.assertEquals(1,test.getID());
		
	}

	@Test
	public void testSetID() {
		test.setID(567);
		Assert.assertEquals(567, test.getID());
	}

	@Test
	public void testGetCustomerName() {
		Assert.assertEquals("Zane", test.getCustomerName());
	}

	@Test
	public void testSetCustomerName() {
		test.setCustomerName("Kam");
		Assert.assertEquals("Kam", test.getCustomerName());
	}

	@Test
	public void testGetAddress() {
		Assert.assertEquals("700N N Woodlawn Ave Hall", test.getAddress());
	}

	@Test
	public void testSetAddress() {
		test.setAddress("Your mom's house");
		Assert.assertEquals("Your mom's house", test.getAddress());
	}

	@Test
	public void testGetNumber() {
		Assert.assertEquals("948910", test.getNumber());
	}

	@Test
	public void testSetNumber() {
		test.setNumber("3637272");
		Assert.assertEquals("3637272", test.getNumber());
	}

}
