package Components;

import GUI_our.Gui_fun;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
    Board board = new Board();
    Gui_fun gui = new Gui_fun();

    public void setupBoard(){
        Player[] players = board.createPlayers(4);

        gui.createBoard();
        gui.createPlayers(players);

    }

    public Board getBoard() {
        return board;
    }

    public Gui_fun getGui() {
        return gui;
    }
}
