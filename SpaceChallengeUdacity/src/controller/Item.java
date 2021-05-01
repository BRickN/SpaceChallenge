package controller;

public class Item {

    private String itemName;
    private int itemWeight;

    //constructor
    public Item(String itemName, int itemWeight) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
    }

    //getters and setters
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemWeight() {
        return itemWeight;
    }
}
