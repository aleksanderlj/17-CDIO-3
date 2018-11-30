//******************************************************************
//  Property.java        Author: Gruppe 17
//
//  Felt som repræsenterer en grund en spiller kan købe
//******************************************************************

package Fields;
import Components.Player;

public class Property extends Field{
    private int value;
    private int rent;
    private Player owner;

    //-------------
    // Constructor
    //-------------
    public Property(int value,int rent){
        this.value = value;
        this.rent = rent;
    }

    //-----------------------------------------------------------------------
    // Når en spiller lander her, betaler han enten leje eller køber grunden
    //-----------------------------------------------------------------------
    public void landOn(Player player){
        if (player != owner){
            if (hasOwner())
                payRent(player);
            else
                buyProperty(player);
        }
    }

    //-------------------------------
    // En spiller betaler leje
    //-------------------------------
    public void payRent(Player player){
        player.addMoney(-rent);
        int balance = player.getBalance();

        if (balance >= 0)
            owner.addMoney(rent);
        else
            owner.addMoney(rent + balance);
    }

    //-------------------------------
    // En spiller køber grunden
    //-------------------------------
    public void buyProperty(Player player){
        player.addMoney(-value);
        int saldo = player.getBalance();

        if (saldo >= 0)
            player.addProperty(this);
    }

    //--------------------------------
    // Tjekker om grunden har en ejer
    //--------------------------------
    public boolean hasOwner(){
        return (owner != null);
    }

    //--------------------
    // Getters og setters
    //--------------------
    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
