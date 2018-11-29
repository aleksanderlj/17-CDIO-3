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
        String description = "";
        /*
        do {
            if (cardIndex < cardDeck.length) {
                switch (cardDeck[cardIndex]) {
                    case 1: {
                        player.setPosition(0);
                        fields[0].landOn(player);
                        description = "Ryk frem til start \n Modtag 2M";
                        break;
                    }
                    case 2: {
                        int choice = ???1, 2, 3, 4, 5;
                        player.move(choice);
                        fields[player.getPosition()].landOn(player);
                        description = "Ryk op til 5 felter frem. \n Indtast antal felter:";
                        break;
                    }
                    case 3: {
                        int choice = ???10, 11;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et orange felt, hvis feltet er ledigt får du det gratis \n " +
                                "Ellers skal du betale leje til ejeren, \n vælg felt 10 eller 11:";
                        break;
                    }
                    case 4: {
                        int choice = ???1, 2;
                        if (choice == 1) {
                            player.move(1);
                            fields[player.getPosition()].landOn(player);
                        } else
                            landOn(player);
                        description = "Ryk et felt frem eller træk et nyt chancekort. " +
                                "\n Tast 1 for at rykke frem, 2 for at trække kort:";
                        break;
                    }
                    case 5: {
                        player.addMoney(-2);
                        description = "Du har spist for meget slik, betal 2M";
                        break;
                    }
                    case 6: {
                        int choice = ???10, 11, 19, 20;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et orange eller grønt felt, er det ledigt får du det gratis \n" +
                                "Ellers betal leje til ejeren. \n Vælg felt 10,11,19 eller 20:";
                        break;
                    }
                    case 7: {
                        int choice = 4, 5;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et lyseblåt felt, hvis feltet er ledigt får du det gratis \n " +
                                "Ellers skal du betale leje til ejeren, \n vælg felt 4 eller 5:";
                        break;
                    }
                    case 8: {
                        player.setReleaseCard(true);
                        description = "Du løslades uden omkostninger, kortet gemmes til du får behov for det.";
                        break;
                    }
                    case 9: {
                        player.setPosition(23);
                        fields[23].landOn(player);
                        description = "Ryk frem til Strandpromenaden.";
                        break;
                    }
                    case 10: {
                        for (int n = 0; n < players.length; n++) {
                            players[n].addMoney(-1);
                            player.addMoney(1);
                        }
                        description = "Det er din fødselsdag! Alle andre spillere giver dig 1M.";
                        break;
                    }
                    case 11: {
                        int choice = 7, 8, 22, 23;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et orange eller grønt felt, er det ledigt får du det gratis \n" +
                                "Ellers betal leje til ejeren. \n Vælg felt 7,8,22 eller 23 ";
                        break;
                    }
                    case 12: {
                        player.addMoney(2);
                        description = "Du har lavet alle dine lektier, modtag 2M fra banken.";
                        break;
                    }
                    case 13: {
                        int choice = 13, 14;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et rødt felt, er feltet ledigt får du det gratis. \n" +
                                "Ellers betal leje til ejeren. \n Vælg felt 13 eller 14:";
                        break;
                    }
                    case 14: {
                        player.setPosition(10);
                        if (fields[10].hasOwner())
                            fields[10].payRent(player);
                        else
                            player.addProperty(fields[10]);
                        description = "Ryk frem til skaterparken for at lave det perfekte grind! \n " +
                                "Hvis ingen ejer den får du den gratis! \n Ellers betal leje til ejeren.";
                        break;
                    }
                    case 15: {
                        int choice = 4, 5, 13, 14;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et lyseblåt eller rødt felt, er det ledigt får du det gratis. \n" +
                                "Ellers skal du betale leje til ejeren.\n Vælg felt 4,5,13 eller 14:";
                        break;
                    }
                    case 16: {
                        int choice = 1, 2, 16, 17;
                        player.setPosition(choice);
                        if (fields[choice].hasOwner())
                            fields[choice].payRent(player);
                        else
                            player.addProperty(fields[choice]);
                        description = "Ryk frem til et lyseblåt eller rødt felt, er det ledigt får du det gratis. \n" +
                                "Ellers skal du betale leje til ejeren.\n Vælg felt 1,2,16 eller 17:";
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