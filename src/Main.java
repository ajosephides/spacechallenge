import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    File fileOne = new File("phase-1.txt");
    File fileTwo = new File("phase-2.txt");

    Scanner phaseOne = new Scanner(fileOne);
    Scanner phaseTwo = new Scanner(fileTwo);

    Simulation u1Simulation = new Simulation();
    Simulation u2Simulation = new Simulation();

    ArrayList<Item> phaseOneItems = u1Simulation.loadItems(phaseOne);
    ArrayList<Item> phaseTwoItems = u2Simulation.loadItems(phaseTwo);

    ArrayList<Rocket> phaseOneU1Rockets = u1Simulation.loadU1(phaseOneItems);
    ArrayList<Rocket> phaseTwoU1Rockets = u1Simulation.loadU1(phaseTwoItems);

    ArrayList<Rocket> phaseOneU2Rockets = u2Simulation.loadU2(phaseOneItems);
    ArrayList<Rocket> phaseTwoU2Rockets = u2Simulation.loadU2(phaseTwoItems);

    System.out.println("The simulated cost of the mission with U1 rockets is: " +
            u1Simulation.runSimulation(phaseOneU1Rockets));

    //System.out.println(phaseOneU2Rockets);
    System.out.println("The simulated cost of the mission with U1 rockets is: " +
            u2Simulation.runSimulation(phaseOneU2Rockets));
  }
}
