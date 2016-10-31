package barber;

public class Cashier extends Thread {
	
	Object lock = new Object();
	
	public void acceptCustomer(Customer customer) {
		synchronized (lock) {
			
			this.notify();
		}
		
	}
	
	public void run() {
		while(true) {
			synchronized (lock) {
				System.out.println("kasiyere ücreti aldı");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
