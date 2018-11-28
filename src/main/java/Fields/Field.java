package Fields;
import Components.Player;

public abstract class Field{
    public abstract void landOn(Player player);





    //Disse tre bliver nødt til at være her for at chance-kortene virker
    public boolean hasOwner(){
        return false;
    }

    public void payRent(Player player){}

    public void setOwner(Player player){}
}