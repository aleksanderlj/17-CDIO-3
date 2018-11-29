package Components;

import Fields.*;
import java.util.Scanner;

public class Board {
    private int startBalance;
    private Field[] fields;
    private Player[] players;
    private String playerName = "Spiller";


    public Board(){
        fields = new Field[]{
                new Start(),
                new Property(1, 1),
                new Property(1, 1),
                new Chance(),
                new Property(1, 1),
                new Property(1, 1),
                new Blank(),
                new Property(2, 2),
                new Property(2, 2),
                new Chance(),
                new Property(2, 2),
                new Property(2, 2),
                new Blank(),
                new Property(3, 3),
                new Property(3, 3),
                new Chance(),
                new Property(3, 3),
                new Property(3, 3),
                new GoToPrison(),
                new Property(4, 4),
                new Property(4, 4),
                new Chance(),
                new Property(5, 5),
                new Property(5, 5)
        };
    }

    public Player[] createPlayers(int numPlayers){
        players = new Player[numPlayers];
        int startBalance = 24 - (numPlayers * 2);

        for (int n=0 ; n < numPlayers ; n++){
            players[n] = new Player(startBalance);
        }

        return players;
    }


    public Field[] getFields() {
        return fields;
    }

    public Player[] getPlayers(){
        return players;
    }
}
