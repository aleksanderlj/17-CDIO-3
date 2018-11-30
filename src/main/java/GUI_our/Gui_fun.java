//******************************************************************
//  Gui_fun.java        Author: Gruppe 17
//
//  Styrer bruger-input samt den visuelle del af programmet
//******************************************************************

package GUI_our;


import Components.Player;
import Fields.*;
import gui_fields.GUI_Car;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

import static gui_fields.GUI_Car.Pattern.FILL;
import static gui_fields.GUI_Car.Type.CAR;
import static java.awt.Color.*;

public class Gui_fun {
    private GUI gui_board;
    private GUI_Player[] gui_players;
    private GUI_Field[] gui_fields;
    private GUI_Street[] gui_streets;

    private Color brown = new Color(125,52,32);
    private Color dark_red = new Color(140, 0,1);
    private Color dark_blue = new Color(3, 0, 102);
    private Color dark_green = new Color(34,139,34);
    private Color deep_purple = new Color(100, 18, 63);
    private Color lighter_blue = new Color(0, 7, 220);
    private Color olivedrab = new Color(107,142,35);
    private Color darkolive = new Color(98, 122, 52);
    private Color light = new Color(138, 168, 108);

    //-----------------------------------------
    // Laver et GUI-bræt og viser brugeren det
    //-----------------------------------------
    public void createBoard(){
        this.gui_fields = new GUI_Field[]{
                new GUI_Start("Start",                  "Modtag 2M",    "Start", green, red),
                new GUI_Street("Burgerbaren",           "1M",           "Burgerbaren",      "1", brown, black),
                new GUI_Street("Pizzariaet",            "1M",           "Pizzariaet",       "1", brown, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Slikbutikken",          "1M",           "Slikbutikken",     "1", cyan, black),
                new GUI_Street("Iskiosken",             "1M",           "Iskiosken",        "1", cyan, black),
                new GUI_Jail("src/main/java/GUI_our/Prison.PNG", "Fængsel", "Fængsel",          "", gray, black),
                new GUI_Street("Museet",                "2M",           "Museet",           "2", magenta, black),
                new GUI_Street("Biblioteket",           "2M",           "Biblioteket",      "2", magenta, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Skaterparken",          "2M",           "Skaterparken",     "2", orange, black),
                new GUI_Street("Swimming-\npoolen",     "2M",           "Swimmingpoolen",   "2", orange, black),
                new GUI_Refuge("default",            "Gratis parkering", "Parkering",           "Gratis parkering\nTag en pause", gray, black),
                new GUI_Street("Spillehallen",          "3M",           "Spillehallen",     "3", red, black),
                new GUI_Street("Biografen",             "3M",           "Biografen",        "3", red, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Legetøjsbutikken",      "3M",           "Legetøjsbutikken", "3", yellow, black),
                new GUI_Street("Dyrehandlen",           "3M",           "Dyrehandlen",      "3", yellow, black),
                new GUI_Jail("default",              "Gå i fængsel",    "Gå i fængsel",        "", gray, black),
                new GUI_Street("Bowlinghallen",         "4M",           "Bowlinghallen",    "4", dark_green, black),
                new GUI_Street("Zoo",                   "4M",           "Zoo",              "4", dark_green, black),
                new GUI_Chance("?",                     "Chancekort",   "Chancekort", green, orange),
                new GUI_Street("Vandlandet",            "5M",           "Vandlandet",       "5", blue, black),
                new GUI_Street("Strand-\npromenaden",   "5M",           "Strandpromenaden", "5", blue, black),
        };

        this.gui_board = new GUI(gui_fields, light);
        gui_board.setDie(1);
    }

    //--------------------------------------------------------------------
    // Spørger brugeren om antal spillere og laver det antal GUI-spillere
    //--------------------------------------------------------------------
    public int createPlayers(){
        String numPlayersInput;
        int numPlayers, startBalance;
        String[] names;
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

        addPlayersToBoard();
        return numPlayers;
    }

    //-------------------------------
    //
    //-------------------------------
    private String[] setPlayerNames(int numPlayers){
        String[] names = new String[numPlayers];

        for (int n=0 ; n < numPlayers ; n++){
            names[n] = gui_board.getUserString("Spiller " + (n+1) + "'s navn: ");
        }

        return names;
    }

    //-------------------------------
    //
    //-------------------------------
    private void addPlayersToBoard(){
        for(GUI_Player player : gui_players){
            gui_board.addPlayer(player);
        }
    }

    //-------------------------------
    //
    //-------------------------------
    public void update(Field[] fields, Player[] players){
        updatePlayerPos(players);
        updateOwnership(fields, players);
        updatePlayerBalance(players);
    }

    //-------------------------------
    //
    //-------------------------------
    private void updatePlayerPos(Player[] players){
        for(int n=0 ; n < players.length ; n++){
            for (int i=0 ; i < gui_fields.length; i++){
                if (players[n].getPosition() == i)
                    gui_fields[i].setCar(gui_players[n],true);
                else
                    gui_fields[i].setCar(gui_players[n], false);
            }
        }
    }

    //-------------------------------
    //
    //-------------------------------
    private void updateOwnership(Field[] data_fields, Player[] data_players){
        for(int i=0 ; i < data_players.length ; i++){
            Color playercolor = gui_players[i].getPrimaryColor();
            for(int h=0 ; h < data_fields.length ; h++){
                if(data_fields[h].getOwner() == data_players[i]){
                    if(gui_fields[h] instanceof GUI_Street){
                        ((GUI_Street)gui_fields[h]).setOwnerName(gui_players[i].getName());
                        ((GUI_Street)gui_fields[h]).setTextColor(playercolor);
                    }
                }
            }
        }
    }

    //-------------------------------
    //
    //-------------------------------
    private void updatePlayerBalance(Player[] players){
        for (int n=0 ; n < gui_players.length ; n++)
            gui_players[n].setBalance(players[n].getBalance());
    }

    //-------------------------------
    //
    //-------------------------------
    public void displayDie(int face){
        gui_board.getUserButtonPressed("Roll","Roll");
        gui_board.setDie(face);
    }

    //-------------------------------
    //
    //-------------------------------
    public void displayEffect(int pos, int index, Field[] data_fields){
        String text = "";

        text += gui_players[index].getName() + " landte på " + gui_fields[pos].getTitle() + "\n";

        if (pos == 0)
            text += "Du får 2M ekstra!";

        else if ((pos % 6) == 3)
            text += Chance.getDescription();

        else if (pos == 6)
            text += "Du er på besøg i fængslet";

        else if (pos == 12)
            text += "";

        else if (pos == 18)
            text += "Du blev smidt i fængsel!";

        else{
            if (data_fields[pos].hasOwner()){
                if (data_fields[pos].getOwner().getId() == index)
                    text += "Du ejer dette felt";
                else
                    text += "Betal " + data_fields[pos].getRent() + "M til " + gui_players[data_fields[pos].getOwner().getId()].getName();
            }
            else
                text += "Du købte den for " + data_fields[pos].getValue() + "M";
        }

        gui_board.displayChanceCard(text);
    }

    //-------------------------------
    //
    //-------------------------------
    public void displayWinner(Player[] players){
        int maxValue = 0;
        String winner = "", text;

        for(int n=0 ; n < players.length ; n++){
            if (players[n].getBalance() > maxValue) {
                maxValue = players[n].getBalance();
                winner = gui_players[n].getName();
            }
        }
        text = winner + " har vundet!";

        gui_board.displayChanceCard(text);
    }
}
