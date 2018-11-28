package GUI_our;


import Components.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

import static gui_fields.GUI_Car.Pattern.FILL;
import static gui_fields.GUI_Car.Type.CAR;
import static java.awt.Color.*;

public class Gui_fun {
    private GUI gui_board;
    private GUI_Player[] gui_players;

    private Color brown = new Color(125,52,32);
    private Color dark_green = new Color(34,139,34);
    private Color olivedrab = new Color(107,142,35);
    private Color darkolive = new Color(98, 122, 52);

    public void createBoard(){
        GUI_Field[] fields = new GUI_Field[]{
                new GUI_Start("Start", "Modtag 2M", "Start", green, red),
                new GUI_Street("Burgerbaren", "1M", "Burgerbaren", "Leje: 1", brown, black),
                new GUI_Street("Pizzariaet", "1M", "Pizzariaet", "Leje: 1", brown, black),
                new GUI_Chance("?", "Chancekort", "Chancekort", green, orange),
                new GUI_Street("Slikbutikken", "1M", "Slikbutikken", "Leje: 1", cyan, black),
                new GUI_Street("Iskiosken", "1M", "Iskiosken", "Leje: 1", cyan, black),
                new GUI_Jail("src/main/java/GUI_our/Prison.PNG", "Fængsel", "Fængsel", "", gray, black),
                new GUI_Street("Museet", "2M", "Museet", "Leje: 2", magenta, black),
                new GUI_Street("Biblioteket", "2M", "Biblioteket", "Leje: 2", magenta, black),
                new GUI_Chance("?", "Chancekort", "Chancekort", green, orange),
                new GUI_Street("Skaterparken", "2M", "Skaterparken", "Leje: 2", orange, black),
                new GUI_Street("Swimming-\npoolen", "2M", "Swimmingpoolen", "Leje: 2", orange, black),
                new GUI_Refuge("default", "Gratis parkering", "Parkering", "Gratis parkering\nTag en pause", gray, black),
                new GUI_Street("Spillehallen", "3M", "Spillehallen", "Leje: 3", red, black),
                new GUI_Street("Biografen", "3M", "Biografen", "Leje: 3", red, black),
                new GUI_Chance("?", "Chancekort", "Chancekort", green, orange),
                new GUI_Street("Legetøjsbutikken", "3M", "Legetøjsbutikken", "Leje: 3", yellow, black),
                new GUI_Street("Dyrehandlen", "3M", "Dyrehandlen", "Leje: 3", yellow, black),
                new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "", gray, black),
                new GUI_Street("Bowlinghallen", "4M", "Bowlinghallen", "Leje: 4", dark_green, black),
                new GUI_Street("Zoo", "4M", "Zoo", "Leje: 4", dark_green, black),
                new GUI_Chance("?", "Chancekort", "Chancekort", green, orange),
                new GUI_Street("Vandlandet", "5M", "Vandlandet", "Leje: 5", blue, black),
                new GUI_Street("Strand-\npromenaden", "5M", "Strandpromenaden", "Leje: 5", blue, black),
        };

        this.gui_board = new GUI(fields, darkolive);
        gui_board.setDie(1);
    }

    public void createPlayers(Player[] players){
        GUI_Player player1=null, player2=null, player3=null, player4=null;

        GUI_Player[] gui_players = new GUI_Player[2];

        GUI_Car car1 = new GUI_Car(red, black, CAR, FILL);
        GUI_Car car2 = new GUI_Car(blue, black, CAR, FILL);

        player1 = new GUI_Player(players[0].getName(), players[0].getBalance(), car1);
        player2 = new GUI_Player(players[1].getName(), players[1].getBalance(), car2);

        gui_players[0] = player1;
        gui_players[1] = player2;


        if (players.length >= 3){
            GUI_Car car3 = new GUI_Car(green, black, CAR, FILL);
            player3 = new GUI_Player(players[2].getName(), players[2].getBalance(), car3);

            gui_players = new GUI_Player[3];
            gui_players[0] = player1;
            gui_players[1] = player2;
            gui_players[2] = player3;

        }

        if (players.length >= 4){
            GUI_Car car4 = new GUI_Car(yellow, black, CAR, FILL);
            player4 = new GUI_Player(players[3].getName(), players[3].getBalance(), car4);

            gui_players = new GUI_Player[4];
            gui_players[0] = player1;
            gui_players[1] = player2;
            gui_players[2] = player3;
            gui_players[3] = player4;

        }

        this.gui_players = gui_players;
    }

    public void addPlayersToBoard(){
        for(GUI_Player player : gui_players){
            gui_board.addPlayer(player);
        }
    }

    public GUI getGui_Board() {
        return gui_board;
    }

    public GUI_Player[] getGui_Players() {
        return gui_players;
    }

    public void updatePlayerPos(Player[] players){
        GUI_Field[] fields = gui_board.getFields();
        for(int n=0 ; n < players.length ; n++){
            for (int i=0 ; i < fields.length; i++){
                if (players[n].getPosition() == i){
                    
                }
            }

        }
    }
}
