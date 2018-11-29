package Components;

import Fields.Field;
import GUI_our.Gui_fun;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
    private Board board = new Board();
    private Gui_fun gui = new Gui_fun();

    public void setupBoard(){
        gui.createBoard();

        int numPlayers = gui.createPlayers();
        board.createPlayers(numPlayers);

        gui.addPlayersToBoard();
    }

    public void playGame(){
        boolean noLoser = true;

        setupBoard();

        Die die = new Die(6);

        //SLET DETTE
        Player[] players = board.getPlayers();
        Field[] fields = board.getFields();
        GUI gui_board = gui.getGui_Board();

        gui.updatePlayerPos(players);

        do{
            for(int n=0 ; n < players.length ; n++){

                if (players[n].getInPrison()) {
                    fields[6].release(players[n]);
                }

                gui_board.getUserButtonPressed("Roll","Roll");
                int roll = die.roll();
                gui_board.setDie(roll);

                players[n].move(roll);
                int position = players[n].getPosition();
                fields[position].landOn(players[n]);

                gui.getGui_Players()[n].setBalance(players[n].getBalance());

                gui.updatePlayerPos(players);
                gui.updateOwnership(fields, players);

                gui.displayEffect(players[n], n);



                if (players[n].getBalance() < 0) {
                    noLoser = false;
                    break;
                }
            }
        } while(noLoser);
    }

    public Board getBoard() {
        return board;
    }

    public Gui_fun getGui() {
        return gui;
    }
}
