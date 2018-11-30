package Fields;

import Components.*;

public class Chance extends Field{
    private static ChanceCards chanceCards = new ChanceCards();
    private static int[] cardDeck = chanceCards.getCardDeck();
    private static int cardIndex = 0;
    private Field[] fields;
    private static String[] description;

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
                        break;
                    }
                    case 2: {
                        player.setReleaseCard(true);
                        break;
                    }

                    case 3: {
                        player.addMoney(-6);
                        break;
                    }
                    case 4: {
                        player.addMoney(-5);
                        break;
                    }
                    case 5: {
                        player.addMoney(-4);
                    }
                    case 6: {
                        player.addMoney(-3);
                        break;
                    }
                    case 7: {
                        player.addMoney(-2);
                        break;
                    }
                    case 8: {
                        player.addMoney(-1);
                        break;
                    }
                    case 9: {
                        player.addMoney(1);
                        break;
                    }
                    case 10: {
                        player.addMoney(2);
                        break;
                    }
                    case 11: {
                        player.addMoney(3);
                        break;
                    }
                    case 12: {
                        player.addMoney(4);
                        break;
                    }
                    case 13: {
                        player.addMoney(5);
                        break;
                    }
                    case 14: {
                        player.addMoney(6);
                        break;
                    }
                    case 15: {
                        player.addMoney(7);
                        break;
                    }
                    case 16: {
                        player.addMoney(8);
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

    public static String[]createDescription(){
        description[0] = "Du tabte til din pokemon rival i først battel, betal 8M.";
        description[1] = "Du får et get-out-of-jail-free-card :=)";
        description[2] = "Din bil har kørt i forlang tid og skal burge reperationer, betal 6M.";
        description[3] = "Du har spist ALT for meget slik, betal 5M.";
        description[4] = "Du brugte din masterball på en pidgey, betal 4M";
        description[5] = "Du har kørt for hurtigt og har fået en fartbøde, betal 3M.";
        description[6] = "Du har spist for meget slik, betal 2M.";
        description[7] = "Du har spist slik, betal 1M.";
        description[8] = "Du går en tur, og ser nogle penge liggende på vejen, modtag 1M";
        description[9] = "Du er heldig at finde et lille lotteri, modtag 2M";
        description[10] = "Du har fundet en shiny pokemon! modtag 3M";
        description[11] = "Du har brugt din masterball på Mewtwo, modtag 4M";
        description[12] = "Du fangede Mewtwo med en normal pokeball!!! modtag 5M";
        description[13] = "Du har vundet en ny bil, og sælger den gamle, modtag 6M";
        description[14] = "Du vandt over the elite four og ham den sidste i alle generations!!! modtag 7M";
        description[15] = "Du har fanget alle pokemoner i alle generationer!!!, modtag 8M";

        return description;
    }

    public static String[] getDescription() {
        return description;
    }
}