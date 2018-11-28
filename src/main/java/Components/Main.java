package Components;

import Fields.Field;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.setupBoard();

        Die die = new Die(6);

        //SLET DETTE
        Player[] players = game.getBoard().getPlayers();
        Field[] fields = game.getBoard().getFields();

        do{
            for(Player player : players){
                int roll = die.roll();
                player.move(roll);
                int position = player.getPosition();
                fields[position].landOn(player);

            }

        } while(true);



    }
}
