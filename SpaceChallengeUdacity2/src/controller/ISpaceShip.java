package controller;

public interface ISpaceShip {

    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);

}
