//******************************************************************
//  GoToPrison.java        Author: Gruppe 17
//
//  Felt som sender dig til fængselsfeltet og styrer løsladelsen
//******************************************************************

package Fields;

import Components.Player;

public class GoToPrison extends Field{

    //-------------------------------------------------
    // Når en spiller lander her, sendes han i fængsel
    //-------------------------------------------------
    public void landOn(Player player) {
        player.setPosition(6);
        player.setInPrison(true);
    }

    //-----------------------------------
    // Kalkulerer en spillers løsladelse
    //-----------------------------------
    public static void release(Player player) {
        if (player.getInPrison()) {
            if (player.getReleaseCard()) {
                player.setReleaseCard(false);
                player.setInPrison(false);
            } else {
                player.addMoney(-1);
                player.setInPrison(false);
            }
        }
    }
}