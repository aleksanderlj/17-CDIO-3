package GUI_our;

import Components.*;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class main_test {
    public static void main(String[] args) {
        Board board = new Board();
        Player[] players = board.createPlayers(4);

        Gui_fun gui = new Gui_fun();
        GUI gui_board = gui.createBoard();
        GUI_Player[] gui_players = gui.createPlayers(players);


        for(GUI_Player player : gui_players){
            gui_board.addPlayer(player);
        }


    }
}
