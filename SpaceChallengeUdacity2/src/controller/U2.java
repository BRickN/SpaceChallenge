package controller;

public class U2 extends Rocket {

    public U2() {
        super(29000, 18000, 120, 0.04, 0.08);
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
