package Fields;

import Components.*;

public class Chance extends Field{
    private static ChanceCards chanceCards = new ChanceCards();
    private static int[] cardDeck = chanceCards.getCardDeck();
    private static int cardIndex = 0;
    private Field[] fields;
    private static String description = "";

    public Chance(Field[] fields){
        this.fields = fields;
    }

    public void landOn(Player player) {
        boolean cardTaken = false;
        playerMoved = false;

        do {
            if (cardIndex < cardDeck.length) {
                switch (cardDeck[cardIndex]) {
                    case 1: {
                        player.setPosition(0);
                        fields[0].landOn(player);
                        description = "Ryk frem til start \n Modtag 2M.";
                        playerMoved = true;
                        break;
                    }
                    case 2: {
                        player.move(3);
                        fields[player.getPosition()].landOn(player);
                        description = "Du har fundet noget superbenzin!!! Ryk 3 felter frem.";
                        playerMoved = true;
                        break;
                    }

                    case 3: {
                        player.setPosition(23);
                        if (fields[23].hasOwner()){
                            fields[23].payRent(player);
                        }
                        else {
                            player.addProperty(fields[23]);
                        }
                        description = "Ryk frem til Strandpromonaden, hvis ingen ejer Strandpromonanden får du den gratis \n " +
                                "ellers skal du betale leje til ejeren.";
                        playerMoved = true;
                        break;
                    }
                    case 4: {
                        if (player.getPosition() < 7){
                            player.setPosition(7);
                        }
                        else{
                            player.addMoney(2);
                            player.setPosition(7);
                        }
                        if (fields[7].hasOwner()) {
                            fields[7].payRent(player);
                        }
                        else {
                            player.addProperty(fields[7]);
                        }
                        description = "Ryk frem til museet, hvis ingen ejer museet får du den gratis \n " +
                                "ellers skal du betale leje til ejeren.";
                        playerMoved = true;
                        break;
                    }
                    case 5: {
                        if (player.getPosition() < 14){
                            player.setPosition(14);
                        }
                        else{
                            player.addMoney(2);
                            player.setPosition(14);
                        }
                        if (fields[14].hasOwner()) {
                            fields[14].payRent(player);
                        }
                        else {
                            player.addProperty(fields[14]);
                        }
                        description = "Ryk frem til biografen, hvis ingen ejer biografen får du den gratis \n " +
                                "Ellers skal du betale leje til ejeren.";
                        playerMoved = true;
                        break;
                    }
                    case 6: {
                        player.addMoney(-2);
                        description = "Du har spist for meget slik, betal 2M.";
                        playerMoved = false;
                        break;
                    }
                    case 7: {
                        player.addMoney(-6);
                        description = "Din bil har forurenet for meget, og du ødelægger klimaet, betal 6M.";
                        playerMoved = false;
                        break;
                    }
                    case 8: {
                        player.setReleaseCard(true);
                        description = "Du løslades uden omkostninger, kortet gemmes til du får behov for det.";
                        playerMoved = true;
                        break;
                    }
                    case 9: {
                        player.addMoney(12);
                        description = "Du har fundet en Goldmine!!! Du modtager 12M.";
                        playerMoved = false;
                        break;
                    }
                    case 10: {
                        player.addMoney(4);
                        description = "Du brugte din masterball på en mewtwo, du modtager 4M";
                        playerMoved = false;
                        break;
                    }
                    case 11: {
                        player.addMoney(4);
                        description = "Du har været heldig og fundet en shiny pokemon, du modtager 4M.";
                        playerMoved = false;
                        break;
                    }
                    case 12: {
                        player.addMoney(3);
                        description = "Du har lavet alle dine lektier, du modtager 3M.";
                        playerMoved = false;
                        break;
                    }
                    case 13: {
                        player.move(-4);
                        description = "Du har kørt for hurtigt og modtager en fartbøde, ryk 4 felter tilbage.";
                        playerMoved = false;
                        break;
                    }
                    case 14: {
                        if (player.getPosition() < 10)
                            player.setPosition(10);
                        else{
                            player.addMoney(2);
                            player.setPosition(10);
                        }
                        if (fields[10].hasOwner()) {
                            fields[10].payRent(player);
                        }
                        else {
                            player.addProperty(fields[10]);
                        }
                        description = "Ryk frem til skaterparken for at lave det perfekte grind! \n " +
                                "Hvis ingen ejer den får du den gratis! \n ellers betal leje til ejeren.";
                        playerMoved = true;
                        break;
                    }
                    case 15: {
                        player.addMoney(-3);
                        description = "Dit ene hjul er gået i stykker, så du bliver nød til at skifte det, betal 3M";
                        playerMoved = false;
                        break;
                    }
                    case 16: {
                        player.addMoney(-4);
                        description = "Du brugte din masterball på en pidgey, betal 4M";
                        playerMoved = false;
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
    }

    public static int getCardIndex() {
        return cardIndex;
    }

    public static int[] getCardDeck() {
        return cardDeck;
    }

    public static String getDescription() {
        return description;
    }
}