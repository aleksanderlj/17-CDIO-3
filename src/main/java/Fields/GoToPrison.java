package Fields;

import Components.Player;

public class GoToPrison extends Field{

    public void landOn(Player player) {
        player.setPosition(6);
        player.setInPrison(true);
    }

    public void release(Player player){
        if (player.getReleaseCard()){
            player.setReleaseCard(false);
            player.setInPrison(false);
        }
        else{
            player.addMoney(-1);
            player.setInPrison(false);
        }
    }
}