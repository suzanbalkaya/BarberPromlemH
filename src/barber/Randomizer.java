package barber;

import java.util.Random;

public class Randomizer {
	
	public static Customer generateCustomer(CustomerType customerType) {
		Random rand = new Random();
		boolean hair = rand.nextBoolean();
		boolean beard = rand.nextBoolean();
		boolean mustache = rand.nextBoolean();
		boolean washHair = rand.nextBoolean();
		Customer customer = new Customer(customerType);
		customer.setBeard(beard);
		customer.setHair(hair);
		customer.setMustache(mustache);
		customer.setWashHair(washHair);
		
		return customer;
		
	}
}
