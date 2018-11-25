package Fields;

import Components.Player;

public class Chance extends Field{
    final int CARDAMOUNT = 24;

    //0=Kat, 1=Hund, 2=Bil, 3=Skib
    public void landOn(Player player) {
        //Random til hvor du lander: 0-23 (hvis liste), 1-24 (hvis switch eller if-loop)

        //1


        //2
        player.setPosition(0);
        fields[0].landOn(player);

        //3
        int choice = ??? 1,2,3,4,5;
        player.move(choice);
        fields[player.getPosition()].landOn(player);

        //4
        int choice = ??? 10,11;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);

        //5
        int choice = ??? 1,2;
        if (choice==1){
            player.move(1);
            fields[player.getPosition()].landOn(player);
        }
        else
            landOn(player);

        //6


        //7
        player.addMoney(-2);

        //8
        int choice = ??? 10,11,19,20;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);

        //9
        int choice = 4,5;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);

        //10
        player.setReleaseCard(true);

        //11
        player.setPosition(23);
        field[23].landOn();

        //12


        //13


        //14
        for(int n=0 ; n < players[].length ; n++) {
            players[n].addMoney(-1);
            player.addMoney(1);
        }

        //15
        int choice = 7,8,22,23;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);

        //16
        player.addMoney(2);

        //17
        int choice = 13,14;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);

        //18


        //19 LAV if-statement ALT EFTER OM DER ER EN FJERDE SPILLER
        players[3].setPosition(0);
        fields[0].landOn(players[3]);

        //20 LAV if-statement ALT EFTER OM DER ER EN TREDJE SPILLER
        players[2].move(1);
        fields[players[2].getPosition()].landOn(players[2]);

        //21
        fields[0].landOn(players[1]);

        //22 Tjek alle spiller positioner og lav:
        // players[0].setPosition(forrest + 1);
        // fields[players[2].getPosition()].landOn(players[2]);


        //23
        int choice = 4,5,13,14;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);

        //24
        int choice = 1,2,16,17;
        player.setPosition(choice);
        if (field[choice].hasOwner())
            field[choice].payRent(player);
        else
            player.addProperty(fields[choice]);


    }
}