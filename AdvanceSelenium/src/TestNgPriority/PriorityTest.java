package TestNgPriority;

import org.testng.annotations.Test;

//Day 43 12/12/2025
//positive priority ,Negative priority , positive and negative Priority
public class PriorityTest {
	@Test(priority=1,groups = "abc")
	public void registration() {
		System.out.println("Registration..");
	}
	@Test(priority=2,groups = "abc")
	public void Login() {
		System.out.println("Login");
	}
	@Test(priority=3)
	public void flightBooking() {
		System.out.println("Flight Booking");
	}

}
