package Fields;

import Components.Die;

public class ChanceCards {
    final static int CARDAMOUNT = 16;
    private int[] cardDeck = new int[CARDAMOUNT];

    public ChanceCards(){
        for(int n = 1 ; n <= cardDeck.length ; n++)
            cardDeck[n-1] = n;

        cardDeck = shuffle(cardDeck);
    }

    public int[] shuffle(int[] cardDeck){
        Die die = new Die(CARDAMOUNT);
        int[] shuffledDeck = new int[CARDAMOUNT];
        int position;

        for(int n = 0 ; n < cardDeck.length ; n++){
            do{
            position = die.roll() - 1;
            }while(shuffledDeck[position] != 0);

            shuffledDeck[position] = cardDeck[n];
        }

        return shuffledDeck;
    }

    public int[] getCardDeck() {
        return cardDeck;
    }
}
