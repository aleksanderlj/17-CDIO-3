package Fields;

import Components.Player;

public class Start extends Field{
    final int PAYDAY = 2;

    public void landOn(Player player) {
        player.addMoney(PAYDAY);
    }
}