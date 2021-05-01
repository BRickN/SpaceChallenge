package controller;

/*  Created by Rick Nieling on 01/05/2021
*   Program launches rockets of different types with payload on space mission
*   determines which rocket is cheapest
*/

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SpaceChallengeLauncher {
    public static void main(String[] args) throws FileNotFoundException {
        //start simulation
        Simulation simulation = new Simulation();

        //initialize variables
        int phaseCosts = 0;
        int totalCostsU1 = 0;
        int totalCostsU2 = 0;
        ArrayList<Item> itemsPhase1 = simulation.loadItems("ItemsListPhase1.txt");
        ArrayList<Item> itemsPhase2 = simulation.loadItems("ItemsListPhase2.txt");


        //fill U1 rockets for both phases
        ArrayList<Rocket> U1RocketsPhaseOne = simulation.loadU1(itemsPhase1);
        ArrayList<Rocket> U1RocketsPhaseTwo = simulation.loadU1(itemsPhase2);

        //print costs per phase
        phaseCosts = simulation.runSimulation(U1RocketsPhaseOne);
        System.out.println("Phase One: ");
        System.out.println("Amount of U1 rockets needed for Phase One: " + (phaseCosts / new U1().getCost()));
        System.out.println("Total costs Phase One with U1 rockets: " + phaseCosts + " million");
        totalCostsU1 += phaseCosts;

        phaseCosts = simulation.runSimulation(U1RocketsPhaseTwo);
        System.out.println("Phase Two: ");
        System.out.println("Amount of U1 rockets needed for Phase Two: " + (phaseCosts / new U1().getCost()));
        System.out.println("Total costs Phase Two with U1 rockets: " + phaseCosts + " million");
        totalCostsU1 += phaseCosts;

        System.out.println("");

        //print total costs
        System.out.println("\tTotal costs of space mission with U1 rockets: " + totalCostsU1 + " million.");

        System.out.println("");


        //fill U2 rockets for both phases
        ArrayList<Rocket> U2RocketsPhaseOne = simulation.loadU2(itemsPhase1);
        ArrayList<Rocket> U2RocketsPhaseTwo = simulation.loadU2(itemsPhase2);

        //print costs per phase
        phaseCosts = simulation.runSimulation(U2RocketsPhaseOne);
        System.out.println("Phase One: ");
        System.out.println("Amount of U2 rockets needed for Phase One: " + (phaseCosts / new U2().getCost()));
        System.out.println("Total costs Phase One with U2 rockets: " + phaseCosts + " million");
        totalCostsU2 += phaseCosts;

        phaseCosts = simulation.runSimulation(U2RocketsPhaseTwo);
        System.out.println("Phase Two: ");
        System.out.println("Amount of U2 rockets needed for Phase Two: " + (phaseCosts / new U2().getCost()));
        System.out.println("Total costs Phase Two with U2 rockets: " + phaseCosts + " million");
        totalCostsU2 += phaseCosts;

        System.out.println("");

        //print total costs
        System.out.println("\tTotal costs of space mission with U2 rockets: " + totalCostsU2 + " million.");

        System.out.println("");

        //determine which rocket type is cheaper
        if(totalCostsU1 < totalCostsU2){
            System.out.println("It is cheaper to use U1 rockets for this space mission.");
        } else{
            System.out.println("It is cheaper to use U2 rockets for this space mission.");
        }
    }
}
