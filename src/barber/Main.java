package barber;

import process.ProcessRunner;

public class Main {

	public static void main(String[] args) {
		BarberSaloon b = new BarberSaloon();
		b.initCustomers();
		
		ProcessRunner.startQueueProcesses();
		
		b.initBarbers();
		b.initCashier();
		
		ProcessRunner.startBarberProcesses();

		ProcessRunner.startCashierProcess();

		
	}

}
