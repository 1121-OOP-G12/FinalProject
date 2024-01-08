
public class Item {
    private String itemName;
    private int availableAmount;

    public Item(String itemName, int availableAmount) {
        this.itemName = itemName;
        this.availableAmount = availableAmount;
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
        } 
    }

    public void giveBack() {
        availableAmount++;
        
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }
}