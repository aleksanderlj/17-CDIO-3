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
                    fields[18].release(players[n]);
                }

                gui_board.getUserButtonPressed("Roll","Roll");
                int roll = die.roll();
                gui_board.setDie(roll);

                int pastPosition = players[n].getPosition();
                players[n].move(roll);
                int position = players[n].getPosition();

                if (pastPosition > position)
                    players[n].addMoney(2);

                gui.update(fields, players);

                if ((position % 6) == 3) {
                    fields[position].landOn(players[n]);
                    gui.displayEffect(3, n, fields);
                }
                else{
                    gui.displayEffect(position, n, fields);
                    fields[position].landOn(players[n]);
                }

                gui.update(fields, players);

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
