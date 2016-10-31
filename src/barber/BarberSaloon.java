package barber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BarberSaloon {
	CustomerType customerType;

	public static List<Customer> customerList = new ArrayList<>(100);
	public static List<Barber> barberList = new ArrayList<>(3);
	public static Cashier cashier = null;

	public static BlockingQueue<Customer> vipChairs = new ArrayBlockingQueue<Customer>(4);
	public static BlockingQueue<Customer> normalChairs = new ArrayBlockingQueue<Customer>(4);
	public static BlockingQueue<Customer> standingCustomers = new ArrayBlockingQueue<Customer>(4);
	public static BlockingQueue<Customer> enteranceWaitingCustomers = new ArrayBlockingQueue<Customer>(10);

	public void initBarbers() {
		for (int i = 1; i <= 3; i++) {
			Barber barber = new Barber();
			barberList.add(barber);
			barber.setName("berber " + i);
			

		}

	}

	public void initCustomers() {
		int vipCount = 1;
		int normalCount = 1;
		boolean vipCustomersIsFull = false;
		Random rnd = new Random();

		while (true) {
			boolean randomBoolean = rnd.nextBoolean();
			if (vipCustomersIsFull || (randomBoolean && normalCount <= 75)) {
				Customer customer = new Customer(customerType.NORMAL);
				customerList.add(customer);
				customer.setName(" Normal Musteri " + normalCount);
				System.out.println(customer.getName() + " oluşturuldu");
				customer.setPriority(Thread.MIN_PRIORITY);
				normalCount++;
				if (normalCount >= 76) {
					break;
				}
				continue;
			}
			if (!randomBoolean && vipCount <= 25) {
				Customer customer = new Customer(customerType.VIP);
				customerList.add(customer);
				customer.setName("VİP Müşteri " + vipCount);

				customer.setPriority(Thread.MAX_PRIORITY);
				System.out.println(customer.getName() + " oluşturuldu");

				vipCount++;
			} else {
				vipCustomersIsFull = true;
			}
		}
	}
	public void initCashier() {
		cashier = new Cashier();
		cashier.setName("Kasiyer");
		System.out.println(cashier.getName() + " oluşturuldu");
	}

}
