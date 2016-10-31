package barber;

public class Barber extends Thread {

	private Customer activeCustomer;
	private boolean isWorking = false;

	@Override
	public void run() {

		while (true) {
			isWorking = true;
			if (!BarberSaloon.vipChairs.isEmpty()) {
				try {
					activeCustomer = BarberSaloon.vipChairs.take();

				} catch (InterruptedException e) {

					e.printStackTrace();
					System.out.println(activeCustomer.getName() + "  kuyruktan alındı ");
					System.out.println(activeCustomer.getName() + " " + this.getName() + "   koltuğuna oturdu ");
				}
				

			} else {
				try {
					activeCustomer = BarberSaloon.normalChairs.take();
					System.out.println(activeCustomer.getName() + "  kuyruktan alındı ");
					System.out.println(activeCustomer.getName() + " " + this.getName() + "  koltuğuna oturdu ");
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				

			}

			doOperation();
			isWorking = false;
			BarberSaloon.cashier.acceptCustomer(activeCustomer);
			System.out.println(activeCustomer.getName() + "  kasiyere ücret ödedi");

		}
	}

	private void doOperation() {
		Integer cost = Util.calculateTotalCost(this.activeCustomer);
		while (cost > 0) {
			try {
				Thread.sleep(CostConstans.TIME_UNIT);
				System.out.println("Berber Çalışıyor");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cost -= CostConstans.BARBER_UNITOFTIME_WORK_COST;
		}
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

}
