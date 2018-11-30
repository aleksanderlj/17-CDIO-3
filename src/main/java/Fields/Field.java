//******************************************************************
//  Field.java        Author: Gruppe 17
//
//  Superklassen til alle felter
//******************************************************************

package Fields;
import Components.Player;

public abstract class Field{
    public abstract void landOn(Player player);


    //Disse bliver nødt til at være her for at field metoderne virker
    public boolean hasOwner(){
        return false;
    }

    public void payRent(Player player){}

    public void setOwner(Player player){}

    public void release(Player player){}

    public Player getOwner(){return null;}

    public int getValue(){return 0;}

    public int getRent(){return 0;}
}