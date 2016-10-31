package barber;


public class Customer extends Thread {
	private boolean mustache = false;
	private boolean beard = false;
	private boolean hair = false;
	private boolean washHair = false;
	private CustomerType customerType;

	@Override
	public void run() {

	}

	public Customer(CustomerType customerType) {
		this.customerType = customerType;
	}

	public boolean isMustache() {
		return mustache;
	}

	public void setMustache(boolean mustache) {
		this.mustache = mustache;
	}

	public boolean isBeard() {
		return beard;
	}

	public void setBeard(boolean beard) {
		this.beard = beard;
	}

	public boolean isHair() {
		return hair;
	}

	public void setHair(boolean hair) {
		this.hair = hair;
	}

	public boolean isWashHair() {
		return washHair;
	}

	public void setWashHair(boolean washHair) {
		this.washHair = washHair;
	}

	public boolean isVip() {
		return this.customerType == CustomerType.VIP;
	}

}
