package Fields;
import Components.Player;

public class Property extends Field{
    private int value;
    private int rent;
    private Player owner;

    public void landOn(Player player){
        if (player != owner){
            if (owner != null)
                payRent(player);
            else
                buyProperty(player);
        }
    }

    public void payRent(Player player){
        player.addMoney(-rent);
        int saldo = player.getBalance();

        if (saldo >= 0)
            owner.addMoney(rent);
        else
            owner.addMoney(rent + saldo);
    }

    public void buyProperty(Player player){
        player.addMoney(-value);
        int saldo = player.getBalance();

        if (saldo >= 0)
            player.addProperty(this);
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
