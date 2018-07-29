public class Item {

  private String name;
  private int mass;

  Item() {
    name = "";
    mass = 0;
  }

  public String getName() {
    return name;
  }

  public int getMass() {
    return mass;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMass(int mass) {
    this.mass = mass;
  }
}
