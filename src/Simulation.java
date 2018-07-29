import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

  private int totalCost;
  private ArrayList<Rocket> u1Rockets;
  private ArrayList<Rocket> u2Rockets;

  Simulation() {
    totalCost = 0;
    u1Rockets = new ArrayList<Rocket>();
    u2Rockets = new ArrayList<Rocket>();
  }

  public ArrayList<Item> loadItems(Scanner file) {

    ArrayList<Item> items = new ArrayList();

    while (file.hasNextLine()) {
      String[] splitLine = file.nextLine().split("=");
      Item item = new Item();
      item.setName(splitLine[0]);
      item.setMass(Integer.parseInt(splitLine[1]));
      items.add(item);
    }

    return items;
  }

  public ArrayList<Rocket> loadU1(ArrayList<Item> items) {

    U1 u1Rocket = new U1();

    for (Item item : items) {
      while (!u1Rocket.canCarry(item)) {
        u1Rockets.add(u1Rocket);
        u1Rocket = new U1();
      }
      u1Rocket.carry(item);
    }
    return u1Rockets;
  }

  public ArrayList<Rocket> loadU2(ArrayList<Item> items) {

    U2 u2Rocket = new U2();

    for (Item item : items) {
      while (!u2Rocket.canCarry(item)) {
        u2Rockets.add(u2Rocket);
        u2Rocket = new U2();
      }
      u2Rocket.carry(item);
    }
    return u2Rockets;
  }

  public int runSimulation(ArrayList<Rocket> rockets) {

    ArrayList<Rocket> crashedRockets = new ArrayList<Rocket>();

    for (Rocket rocket : rockets) {

      if (rocket.launch() && rocket.land()) {
        totalCost = totalCost + rocket.cost;

      } else {
        totalCost = totalCost + rocket.cost;
        crashedRockets.add(rocket);
        //System.out.println("Rocket Crashed");
      }
    }

    if (!crashedRockets.isEmpty()) {
      runSimulation(crashedRockets);
    }
    return totalCost;
  }
}
