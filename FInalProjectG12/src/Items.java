public class Items {

	private String dormName;
	private String itemName;
	private int availableAmount;

	public Items(String dormName, String itemName, int availableAmount) {
		this.dormName = dormName;
		this.itemName = itemName;
		this.availableAmount = availableAmount;

	}

	public String getDormName() {
		return dormName;
	}

	public String getItemName() {
		return itemName;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public void borrow() {

		if (availableAmount > 0) {
			availableAmount--;
			System.out.println("You successfully borrowed 1 " + itemName + ".");
		} else {
			System.out.println("It" + "\'" + " s unavaliable to borrow 1 " + itemName + ".");
		}

	}

	public void giveBack() {

		availableAmount++;
		System.out.println("You successfully returned 1 " + itemName + ".");
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
}