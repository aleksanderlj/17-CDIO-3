package Components;

import Fields.Field;

public class MonopolyJunior {
    private static Board board  = new Board();

    public static void main(String[] args) {
        Player[] players = board.createPlayers();
        Field[] field = board.getFields();


    }

    public static Board getBoard(){
        return board;
    }
}
