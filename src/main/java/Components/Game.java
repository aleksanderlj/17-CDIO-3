//******************************************************************
//  Game.java        Author: Gruppe 17
//
//  Controller som tager input fra data og view og sætter det sammen
//******************************************************************

package Components;

import Fields.Field;
import Fields.GoToPrison;
import GUI_our.Gui_fun;

public class Game {
    private Board board = new Board();
    private Gui_fun gui = new Gui_fun();

    //-------------------------------------------------------------
    // Sætter et gui-bræt op og spørger brugeren om antal spillere
    //-------------------------------------------------------------
    private void setupBoard(){
        gui.createBoard();

        int numPlayers = gui.createPlayers();
        board.createPlayers(numPlayers);
    }

    //--------------------------------------------------------------------------
    // Styrer hele spillets forløb (inklusiv runder), samt et par mindre regler
    //--------------------------------------------------------------------------
    public void playGame(){
        boolean noLoser = true;
        Die die = new Die(6);

        setupBoard();

        Player[] players = board.getPlayers();
        Field[] fields = board.getFields();

        gui.update(fields, players);

        do{
            for(int n=0 ; n < players.length ; n++){

                GoToPrison.release(players[n]);

                int roll = die.roll();
                gui.displayDie(roll);

                players[n].move(roll);
                int position = players[n].getPosition();

                gui.update(fields, players);

                gui.displayEffect(position, n, fields);
                fields[position].landOn(players[n]);

                gui.update(fields, players);

                if (players[n].getBalance() < 0) {
                    noLoser = false;
                    break;
                }
            }
        } while(noLoser);

        gui.displayWinner(players);
    }
}
