package Components;

import Fields.*;

public class Board {
    private int startBalance;
    private Field[] fields;
    private Player[] players;
    private String playerName = "Spiller";


    public Board(){
        int i = 0;
        fields = new Field[24];

        fields[i++] = new Start();
        fields[i++] = new Property(1, 1);
        fields[i++] = new Property(1, 1);
        fields[i++] = new Chance(fields);
        fields[i++] = new Property(1, 1);
        fields[i++] = new Property(1, 1);
        fields[i++] = new Blank();
        fields[i++] = new Property(2, 2);
        fields[i++] = new Property(2, 2);
        fields[i++] = new Chance(fields);
        fields[i++] = new Property(2, 2);
        fields[i++] = new Property(2, 2);
        fields[i++] = new Blank();
        fields[i++] = new Property(3, 3);
        fields[i++] = new Property(3, 3);
        fields[i++] = new Chance(fields);
        fields[i++] = new Property(3, 3);
        fields[i++] = new Property(3, 3);
        fields[i++] = new GoToPrison();
        fields[i++] = new Property(4, 4);
        fields[i++] = new Property(4, 4);
        fields[i++] = new Chance(fields);
        fields[i++] = new Property(5, 5);
        fields[i++] = new Property(5, 5);
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
