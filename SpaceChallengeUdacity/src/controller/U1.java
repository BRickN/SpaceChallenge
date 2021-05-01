package controller;

public class U1 extends Rocket {

    public U1() {
        super(18000,  10000, 100, 0.05, 0.01);
    }

    //launch method. Returns true if launch is successful
    @Override
    public boolean launch() {
        double failChance = getLaunchExplosionChange() * ((double) getMaxCapacity() - getRocketWeight() - getCurrentCapacity()) / (getMaxCapacity() - getRocketWeight());
        double randomNumber = Math.random() * 0.1;
        return randomNumber > failChance;
    }

    //land method. Returns true if launch is successful
    @Override
    public boolean land() {

        double failChance = getLandExplosionChange() * ((double) getMaxCapacity() - getRocketWeight() - getCurrentCapacity()) / (getMaxCapacity() - getRocketWeight());
        double randomNumber = Math.random() * 0.1;

        return randomNumber > failChance;
    }


}
