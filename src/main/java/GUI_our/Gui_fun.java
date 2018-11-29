package GUI_our;


import Components.Player;
import Fields.Field;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

import static gui_fields.GUI_Car.Pattern.FILL;
import static gui_fields.GUI_Car.Type.CAR;
import static java.awt.Color.*;

public class Gui_fun {
    private GUI gui_board;
    private GUI_Player[] gui_players;
    private GUI_Field[] gui_fields;

    private Color brown = new Color(125,52,32);
    private Color dark_green = new Color(34,139,34);
    private Color olivedrab = new Color(107,142,35);
    private Color darkolive = new Color(98, 122, 52);
    private Color light = new Color(138, 168, 108);

    public void createBoard(){
        this.gui_fields = new GUI_Field[]{
                new GUI_Start("Start",                  "Modtag 2M",    "Start", green, red),
                new GUI_Street("Burgerbaren",           "1M",           "Burgerbaren",      "Leje: 1", brown, black),
                new GUI_Street("Pizzariaet",            "1M",           "Pizzariaet",       "Leje: 1", brown, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Slikbutikken",          "1M",           "Slikbutikken",     "Leje: 1", cyan, black),
                new GUI_Street("Iskiosken",             "1M",           "Iskiosken",        "Leje: 1", cyan, black),
                new GUI_Jail("src/main/java/GUI_our/Prison.PNG", "Fængsel", "Fængsel",          "", gray, black),
                new GUI_Street("Museet",                "2M",           "Museet",           "Leje: 2", magenta, black),
                new GUI_Street("Biblioteket",           "2M",           "Biblioteket",      "Leje: 2", magenta, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Skaterparken",          "2M",           "Skaterparken",     "Leje: 2", orange, black),
                new GUI_Street("Swimming-\npoolen",     "2M",           "Swimmingpoolen",   "Leje: 2", orange, black),
                new GUI_Refuge("default",            "Gratis parkering", "Parkering",           "Gratis parkering\nTag en pause", gray, black),
                new GUI_Street("Spillehallen",          "3M",           "Spillehallen",     "Leje: 3", red, black),
                new GUI_Street("Biografen",             "3M",           "Biografen",        "Leje: 3", red, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Legetøjsbutikken",      "3M",           "Legetøjsbutikken", "Leje: 3", yellow, black),
                new GUI_Street("Dyrehandlen",           "3M",           "Dyrehandlen",      "Leje: 3", yellow, black),
                new GUI_Jail("default",              "Gå i fængsel",    "Gå i fængsel",        "", gray, black),
                new GUI_Street("Bowlinghallen",         "4M",           "Bowlinghallen",    "Leje: 4", dark_green, black),
                new GUI_Street("Zoo",                   "4M",           "Zoo",              "Leje: 4", dark_green, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Vandlandet",            "5M",           "Vandlandet",       "Leje: 5", blue, black),
                new GUI_Street("Strand-\npromenaden",   "5M",           "Strandpromenaden", "Leje: 5", blue, black),
        };

        this.gui_board = new GUI(gui_fields, light);
        gui_board.setDie(1);
    }

    public int createPlayers(){
        String numPlayersInput;
        int numPlayers, startBalance;
        String[] names;
        GUI_Player[] gui_players;
        GUI_Car car1, car2, car3, car4;
        car1 = new GUI_Car(red, black, CAR, FILL);
        car2 = new GUI_Car(blue, black, CAR, FILL);
        car3 = new GUI_Car(green, black, CAR, FILL);
        car4 = new GUI_Car(yellow, black, CAR, FILL);
        GUI_Car[] cars = {car1, car2, car3, car4};

        numPlayersInput = gui_board.getUserSelection("Hvor mange spillere?", "2", "3", "4");
        numPlayers = Integer.parseInt(numPlayersInput);
        startBalance = 24 - (numPlayers * 2);

        names = setPlayerNames(numPlayers);

        this.gui_players = new GUI_Player[numPlayers];

        for (int n=0 ; n < numPlayers ; n++){
            this.gui_players[n] = new GUI_Player(names[n], startBalance, cars[n]);
        }

        return numPlayers;
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
        for(int n=0 ; n < players.length ; n++){
            for (int i=0 ; i < gui_fields.length; i++){
                if (players[n].getPosition() == i)
                    gui_fields[i].setCar(gui_players[n],true);
                else
                    gui_fields[i].setCar(gui_players[n], false);
            }

        }
    }

    public void updateOwnership(Field[] data_fields, Player[] data_players){
        for(int i=0 ; i < data_players.length ; i++){
            for(int h=0 ; h < data_fields.length ; h++){
                if(data_fields[h].getOwner() == data_players[i]){
                    gui_fields[h].setDescription(gui_fields[h].getDescription() + "<" + gui_players[i].getName() + ">");
                }
            }
        }
    }

    public String[] setPlayerNames(int numPlayers){
        String[] names = new String[numPlayers];

        for (int n=0 ; n < numPlayers ; n++){
            names[n] = gui_board.getUserString("Spiller " + (n+1) + "'s navn: ");
        }

        return names;
    }
}
