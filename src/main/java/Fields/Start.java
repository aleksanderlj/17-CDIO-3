//******************************************************************
//  Start.java        Author: Gruppe 17
//
//  Start feltet
//******************************************************************

package Fields;

import Components.Player;

public class Start extends Field{
    final int PAYDAY = 2;

    //-----------------------------------------------------
    // Hvis en spiller lander på start, får de bonus-penge
    //-----------------------------------------------------
    public void landOn(Player player) {
        player.addMoney(PAYDAY);
    }
}