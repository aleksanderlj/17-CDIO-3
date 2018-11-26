package Components;

import Fields.*;

public class Board {
    private int numberPlayers;
    private Field[] fields;
    private Player[] players = new Player[numberPlayers];

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
        numberPlayers = 2;

        if (numberPlayers < 2){
            System.out.println("For få spillere");
        }

        else if (numberPlayers > 4){
            System.out.println("for mange spillere");
        }

        else{
            for (int i = 0 ; i < players.length ; i++){
                players[i] = new Player();
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
