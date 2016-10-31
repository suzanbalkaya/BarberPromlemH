package process;

import barber.BarberSaloon;
import barber.Customer;

public class EntrenceProcess implements ProcessIntf {

	@Override
	public void doProcess() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					Customer c = BarberSaloon.customerList.remove(0);
					
					try {
						BarberSaloon.enteranceWaitingCustomers.put(c);
						System.out.println(c.getName()+ " Dısarıda sıraya girdi ");
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
				
			}
		};
		new Thread(runnable).start();
	}

}
