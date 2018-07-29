public class U1 extends Rocket {

  private int rocketMass;
  private int maxMass;
  private double launchChance;
  private double landChance;

  U1() {
    cost = 100;
    rocketMass = 10000;
    maxMass = 18000;
    maxCargoMass = maxMass - rocketMass;
  }

  public boolean launch() {
    double random = Math.random();
    double launchChance = calcLaunchChance();
    if (random > launchChance) {
      return true;
    } else {
      return false;
    }
  }

  public boolean land() {
    double random = Math.random();
    if (random > calcLandChance()) {
      return true;
    } else {
      return false;
    }
  }

  private double calcLaunchChance() {

    launchChance = 0.05 * ((double) currentCargoMass / (maxCargoMass));
    return launchChance;
  }

  private double calcLandChance() {

    landChance = 0.01 * ((double) currentCargoMass / (maxCargoMass));
    return landChance;
  }
}
