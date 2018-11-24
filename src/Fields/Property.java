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
        int saldo = player.getMoney();

        if (saldo >= 0)
            owner.addMoney(rent);
        else
            owner.addMoney(rent + saldo);
    }

    public void buyProperty(Player player){
        player.addMoney(-value);
        int saldo = player.getMoney();

        if (saldo >= 0)
            owner = player;
    }
}
