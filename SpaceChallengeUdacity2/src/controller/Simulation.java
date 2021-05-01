package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //default constructor
    public Simulation() {
    }

    //Method reads name and weight of items of a text file and saves them in a List
    //Parameter(s): file name (String)
    //Return: item list (ArrayList)
    public ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        //create item list
        ArrayList<Item> itemList = new ArrayList<>();

        //create file object
        File items = new File(fileName);

        //create scanner of the file
        Scanner scanner = new Scanner(items);

        while (scanner.hasNextLine()) {
            //scan item line and separate name and weight
            String itemLine = scanner.nextLine();
            String[] parts = itemLine.split("=");

            //initialize item object and add to item list
            itemList.add(new Item(parts[0], Integer.parseInt(parts[1])));
        }
        return itemList;
    }

    //Method loads items in U1 rockets and saves the rockets in a list
    //Parameter(s): item list (ArrayList)
    //Return: rockets (ArrayList)
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        //create ArrayList of U1 rockets
        ArrayList<Rocket> U1RocketsList = new ArrayList<>();

        //create copy of Item List to edit
        ArrayList<Item> itemListCopy = new ArrayList<>(items);

        //start loading rockets
        do {
            //create new rocket object
            Rocket rocketU1 = new U1();
            //loop for every item on the copy list and add whichever fits in the rocket
            for (int i = 0; i < itemListCopy.size(); i++) {
                //if rocket has enough capacity for an item on the list:
                if (rocketU1.canCarry(itemListCopy.get(i))) {
                    //add that item to the rocket
                    rocketU1.carry(itemListCopy.get(i));
                    //remove the item from the list
                    itemListCopy.remove(i);
                    //set index 1 back because removing the carried item shifted indices
                    i--;
                }
            }
            //add the filled rocket to the list of rockets
            U1RocketsList.add(rocketU1);

            //loop while the copied list is not empty
        } while (!itemListCopy.isEmpty());
        return U1RocketsList;
    }


    //Method loads items in U2 rockets and saves the loaded rockets in a list
    //Parameter(s): item list (ArrayList)
    //Return: rockets (ArrayList)
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        //create arrayList of U1 rockets
        ArrayList<Rocket> U2RocketsList = new ArrayList<>();

        //create copy of Item List to edit
        ArrayList<Item> itemListCopy = new ArrayList<>(items);

        //start loading rockets
        do {
            //create new rocket object
            Rocket rocketU2 = new U2();
            //loop for every item on the copy list and add whichever fits in the rocket
            for (int i = 0; i < itemListCopy.size(); i++) {
                //if rocket object can carry an item on the list:
                if (rocketU2.canCarry(itemListCopy.get(i))) {
                    //add that item to the rocket
                    rocketU2.carry(itemListCopy.get(i));
                    //remove the item from the list
                    itemListCopy.remove(i);
                    //set counter i 1 back because removing the carried item shifted indices 1 place back
                    i--;
                }
            }
            //add the filled rocket to the list of rockets
            U2RocketsList.add(rocketU2);

            //loop while the copied item list is not empty
        } while (!itemListCopy.isEmpty());
        return U2RocketsList;
    }

    //Method runs the simulation of launching and landing the loaded rockets
    //Parameter(s): rocket list (ArrayList)
    //Return: total mission costs (int)
    public int runSimulation(ArrayList<Rocket> rockets) {
        //initialize total costs
        int totalCosts = 0;

        //loop every rocket in the list and determine if launching && landing was successful
        for (int i = 0; i < rockets.size(); i++) {
            if (rockets.get(i).launch() && rockets.get(i).land()) {
                totalCosts += rockets.get(i).getCost();
            } else {
                totalCosts += rockets.get(i).getCost();
                i--;
            }
        }
        return totalCosts;
    }
}
