package controller;

public class Rocket implements ISpaceShip {

    private int maxCapacity;
    private int currentCapacity;
    private int rocketWeight;
    private int cost;
    private double launchExplosionChange;
    private double landExplosionChange;

    //default constructor
    public Rocket(){
    }

    //constructor
    public Rocket(int maxCapacity, int rocketWeight, int cost, double launchExplosionChange, double landExplosionChange) {
        this.maxCapacity = maxCapacity;
        this.rocketWeight = rocketWeight;
        this.currentCapacity = maxCapacity - rocketWeight;
        this.cost = cost;
        this.launchExplosionChange = launchExplosionChange;
        this.landExplosionChange = landExplosionChange;
    }

    //launch method. Returns true if launch is successful
    public boolean launch() {
        return true;
    }

    //land method. Returns true if launch is successful
    public boolean land() {
        return true;
    }

    //determine if the rocket has enough capacity to carry the item
    public boolean canCarry(Item item) {
        if (item.getItemWeight() <= getCurrentCapacity()) {
            return true;
        } else {
            return false;
        }
    }

    //decrease capacity of the rocket based on the item weight
    public void carry(Item item) {
        if (canCarry(item)) {
            this.currentCapacity -= item.getItemWeight();
        }
    }

    //getters
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getCost() {
        return cost;
    }

    public double getLaunchExplosionChange() {
        return launchExplosionChange;
    }

    public double getLandExplosionChange() {
        return landExplosionChange;
    }
}
