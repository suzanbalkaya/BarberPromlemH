package barber;

public class Util {
	public static Integer calculateTotalCost(Customer customer) {
		CostConstans costConstans = new CostConstans();
		Integer totalCost = 0;
		if (customer.isBeard()) {
			totalCost = costConstans.BEARD_COST;
		}
		if (customer.isHair()) {
			totalCost += costConstans.HAIR_COST;
		}
		if (customer.isMustache()) {
			totalCost += costConstans.MUSTACHE_COST;

		}
		if (customer.isWashHair()) {
			totalCost += costConstans.WASH_HAIR_COST;
		}

		return totalCost;
	}

	public static Integer processBarberProcess(Integer cost, Integer work) {
		return 0;

	}
}
