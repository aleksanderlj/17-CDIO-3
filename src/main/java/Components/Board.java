package Components;

import Fields.*;
import java.util.Scanner;

public class Board {
    private int startBalance;
    private Field[] fields;
    private Player[] players;
    private String playerName = "Navn";


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

    public Player[] createPlayers(int numberPlayers){
        if (numberPlayers < 2) {
            System.out.println("For få spillere");
        }
        else if (numberPlayers > 4) {
            System.out.println("for mange spillere");
        }
        else {

            if (numberPlayers == 2) {
                players = new Player[2];
                startBalance = 20;
            }
            else if (numberPlayers == 3){
                players = new Player[3];
                startBalance = 18;
            }
            else{
                players = new Player[4];
                startBalance = 16;
            }

            for (int i = 0; i < players.length; i++) {
                players[i] = new Player(playerName, startBalance);
            }
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
