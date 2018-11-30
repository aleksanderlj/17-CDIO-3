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
        boolean cardTaken;

        do {
            if (cardIndex < cardDeck.length) {
                switch (cardDeck[cardIndex]) {
                    case 1: {
                        player.addMoney(-8);
                        description = "Du har spist for ALT meget slik, betal 8M.";
                        break;
                    }
                    case 2: {
                        player.setReleaseCard(true);
                        description = "Du får en get-out-of-jail-free-card :=)";
                        break;
                    }

                    case 3: {
                        player.addMoney(-6);
                        description = "Du har drukket for meget sodavand, betal 6M.";
                        break;
                    }
                    case 4: {
                        player.addMoney(-5);
                        description = "Du har spist ret meget for meget slik, betal 5M.";
                        break;
                    }
                    case 5: {
                        player.addMoney(-4);
                        description = "Du brugte din masterball på en pidgey, betal 4M";
                    }
                    case 6: {
                        player.addMoney(-3);
                        description = "Du har spist okay for meget slik, betal 3M.";
                        break;
                    }
                    case 7: {
                        player.addMoney(-2);
                        description = "Du har spist for meget slik, betal 2M.";
                        break;
                    }
                    case 8: {
                        player.addMoney(-1);
                        description = "Du har spist slik, betal 1M.";
                        break;
                    }
                    case 9: {
                        player.addMoney(1);
                        description = "Du har ikke spist slik, modtag 1M";
                        break;
                    }
                    case 10: {
                        player.addMoney(2);
                        description = "Du har slet ikke spist slik, modtag 2M";
                        break;
                    }
                    case 11: {
                        player.addMoney(3);
                        description = "Du har fundet en shiny pokemon! modtag 3M";
                        break;
                    }
                    case 12: {
                        player.addMoney(4);
                        description = "Du har brugt din masterball på Mewtwo, modtag 4M";
                        break;
                    }
                    case 13: {
                        player.addMoney(5);
                        description = "Du har overhovedet ikke spist slik, modtag 5M";
                        break;
                    }
                    case 14: {
                        player.addMoney(6);
                        description = "Du har aldrig ikke spist slik, modtag 6M";
                        break;
                    }
                    case 15: {
                        player.addMoney(7);
                        description = "Du vandt over the elite four og ham den sidste i alle generations!!! modtag 7M";
                        break;
                    }
                    case 16: {
                        player.addMoney(8);
                        description = "Du har fanget alle pokemons, som findes, modtag 8M";
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

    public static String getDescription() {
        return description;
    }
}