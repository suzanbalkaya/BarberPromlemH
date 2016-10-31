package process;

import barber.BarberSaloon;
import barber.Customer;

public class VipOrNormalCustomerProcess implements ProcessIntf {

	@Override
	public void doProcess() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				while (true) {
					Customer customer = null;
					try {
						customer = BarberSaloon.standingCustomers.take();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println(customer.getName()+ " içerdeki bekleme alanından alındı");
					try {
						if (customer.isVip()) {
							BarberSaloon.vipChairs.put(customer);
							System.out.println(customer.getName()+" Vip koltuguna geçti");

						} else {
							BarberSaloon.normalChairs.put(customer);
							System.out.println(customer.getName()+ "  normal koltuga geçti");
						}

					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}

			}
		};
		new Thread(runnable).start();
	}

}