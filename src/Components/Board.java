package Components;

import Fields.*;

public class Board {
    private Field[] fields;
    private Player[] players;

    public void createBoard(){

        Field[] fields = {
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

    public Field[] getFields() {
        return fields;
    }

    public Player[] getPlayers(){
        return players;
    }
}
