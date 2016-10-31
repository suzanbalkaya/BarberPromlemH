package process;

import barber.Barber;
import barber.BarberSaloon;
import barber.Cashier;

public class ProcessRunner {

	public static void startQueueProcesses() {
		EntrenceProcess entrenceProcess = new EntrenceProcess();
		entrenceProcess.doProcess();

		StandingCustomerProcess standingCustomerProcess = new StandingCustomerProcess();
		standingCustomerProcess.doProcess();

		VipOrNormalCustomerProcess customerProcess = new VipOrNormalCustomerProcess();
		customerProcess.doProcess();

	}

	public static void startBarberProcesses() {
		
		for(int i = 0 ; i < 3; i++) {
			BarberSaloon.barberList.get(i).start();
			System.out.println(BarberSaloon.barberList.get(i).getName() + " işe başladı");
		}
	}

	public static void startCashierProcess() {
		BarberSaloon.cashier.start();
		System.out.println(BarberSaloon.cashier.getName() + " İşe başladı");

	}

}
