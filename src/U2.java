public class U2 extends Rocket {

  private int rocketMass;
  private int maxMass;
  private double launchChance;
  private double landChance;

  U2() {
    cost = 120;
    rocketMass = 18000;
    maxMass = 29000;
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

    launchChance = 0.04 * ((double) currentCargoMass / (maxCargoMass));
    return launchChance;
  }

  private double calcLandChance() {

    landChance = 0.08 * ((double) currentCargoMass / (maxCargoMass));
    return landChance;
  }
}
