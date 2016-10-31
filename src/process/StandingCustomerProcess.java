package process;

import barber.BarberSaloon;
import barber.Customer;

public class StandingCustomerProcess implements ProcessIntf {

	@Override
	public void doProcess() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while (true) {
					Customer customer = null;
					try {
						customer = BarberSaloon.enteranceWaitingCustomers.take();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println(customer.getName()+ " dışardaki sıradan alındı");
					try {
						BarberSaloon.standingCustomers.put(customer);
						System.out.println(customer.getName()+ " İçerdeki bekleme alanında sıraya girdi ");
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}

			}
		};
		new Thread(runnable).start();
	}

}