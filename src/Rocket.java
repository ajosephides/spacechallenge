
public class Rocket implements SpaceShip {

    public int currentCargoMass;
    public int maxCargoMass;
    public int cost;


    Rocket(){
        currentCargoMass = 0;
    }

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public boolean canCarry(Item item){
        if((currentCargoMass + item.getMass()) <= maxCargoMass){
            return true;
        } else{
            return false;
        }
    }

    public void carry(Item item){
        currentCargoMass = currentCargoMass + item.getMass();
    }


}
