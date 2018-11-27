package Components;

import Fields.*;
import java.util.Scanner;

public class Board {
    private int numberPlayers, startBalance;
    private Field[] fields;
    private Player[] players = new Player[numberPlayers];
    private String playerName;


    public Board(){
        fields = {
                new Start(),
                new Property(1,1),
                new Property(1,1),
                new Chance(),
                new Property(1,1),
                new Property(1,1),
                new Blank(),
                new Property(2,2),
                new Property(2,2),
                new Chance(),
                new Property(2,2),
                new Property(2,2),
                new Blank(),
                new Property(3,3),
                new Property(3,3),
                new Chance(),
                new Property(3,3),
                new Property(3,3),
                new GoToPrison(),
                new Property(4,4),
                new Property(4,4),
                new Chance(),
                new Property(5,5),
                new Property(5,5)
                };
    }

    public Player[] createPlayers(){
        Scanner input = new Scanner(System.in);
        numberPlayers = input.nextInt();

        if (numberPlayers < 2) {
            System.out.println("For få spillere");
        }
        else if (numberPlayers > 4) {
            System.out.println("for mange spillere");
        }
        else {

            if (numberPlayers == 2) {
                startBalance = 20;
            }
            else if (numberPlayers == 3){
                startBalance = 18;
            }
            else{
                startBalance = 16;
            }

            for (int i = 0; i < players.length; i++) {
                playerName = input.nextLine();
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
