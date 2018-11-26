package Fields;

import Components.*;

public class Chance extends Field{
    private static ChanceCards chanceCards = new ChanceCards();
    private static int[] cardDeck = chanceCards.getCardDeck();
    private static int cardIndex = 0;
    private static Field[] fields = MonopolyJunior.getBoard().getFields();
    private static Player[] players = MonopolyJunior.getBoard().getPlayers();

    //0=Kat, 1=Hund, 2=Bil, 3=Skib
    public void landOn(Player player) {
        boolean cardTaken = false;

        do {
            if (cardIndex < cardDeck.length) {
                switch (cardDeck[cardIndex]) {
                    case 1: {
                        player.setPosition(0);
                        fields[0].landOn(player);
                        break;
                    }
                    case 2: {
                        int choice = ???1, 2, 3, 4, 5;
                        player.move(choice);
                        fields[player.getPosition()].landOn(player);
                        break;
                    }
                    case 3: {
                        int choice = ???10, 11;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    case 4: {
                        int choice = ???1, 2;
                        if (choice == 1) {
                            player.move(1);
                            fields[player.getPosition()].landOn(player);
                        } else
                            landOn(player);
                        break;
                    }
                    case 5: {
                        player.addMoney(-2);
                        break;
                    }
                    case 6: {
                        int choice = ???10, 11, 19, 20;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    case 7: {
                        int choice = 4, 5;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    case 8: {
                        player.setReleaseCard(true);
                        break;
                    }
                    case 9: {
                        player.setPosition(23);
                        fields[23].landOn();
                        break;
                    }
                    case 10: {
                        for (int n = 0; n < players.length; n++) {
                            players[n].addMoney(-1);
                            player.addMoney(1);
                        }
                        break;
                    }
                    case 11: {
                        int choice = 7, 8, 22, 23;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    case 12: {
                        player.addMoney(2);
                        break;
                    }
                    case 13: {
                        int choice = 13, 14;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    case 14: {
                        player.setPosition(10);
                        if (fields[10].hasOwner())
                            fields[10].payRent(player);
                        else
                            player.addProperty(fields[10]);
                        break;
                    }
                    case 15: {
                        int choice = 4, 5, 13, 14;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    case 16: {
                        int choice = 1, 2, 16, 17;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        break;
                    }
                    default: {

                        break;
                    }
                }
                cardIndex++;
                cardTaken = true;
            } else {
                cardDeck = chanceCards.shuffle(cardDeck);
                cardIndex = 0;
                cardTaken = false;
            }
        } while(!cardTaken);


        //***********"LAV AMOUNT OF CARDS MINDRE HVIS DU IKKE INDSÆTTER SPILLER-SPECIFIKKE CHANCEKORT";************
        /*
        // Spiller-specifikke chancekort:
        //1


        //6


        //12


        //13


        //19 LAV if-statement ALT EFTER OM DER ER EN FJERDE SPILLER. ELLERS SKAL DE TAGE ET NYT KORT.
        players[3].setPosition(0);
        fields[0].landOn(players[3]);

        //20 LAV if-statement ALT EFTER OM DER ER EN TREDJE SPILLER. ELLERS SKAL DE TAGE ET NYT KORT.
        players[2].move(1);
        fields[players[2].getPosition()].landOn(players[2]);

        //21
        fields[0].landOn(players[1]);

        //22 Tjek alle spiller positioner og lav:
        // players[0].setPosition(forrest + 1);
        // fields[players[2].getPosition()].landOn(players[2]);

        */


    }

    public static int getCardIndex() {
        return cardIndex;
    }

    public static int[] getCardDeck() {
        return cardDeck;
    }
}