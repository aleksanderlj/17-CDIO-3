//******************************************************************
//  ChanceCards.java        Author: Gruppe 17
//  Support til Chance.java
//  Laver et dæk kort og blander dem
//******************************************************************

package Fields;

import Components.Die;

public class ChanceCards {
    final static int CARDAMOUNT = 16;
    private int[] cardDeck = new int[CARDAMOUNT];

    //---------------------------------------------------------
    // Contructor, laver et dæk af kort (int's) og blander dem
    //---------------------------------------------------------
    public ChanceCards(){
        for(int n = 1 ; n <= cardDeck.length ; n++)
            cardDeck[n-1] = n;

        cardDeck = shuffle(cardDeck);
    }

    //-------------------------------
    // Blander et dæk af kort
    //-------------------------------
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

    //-------------------------------
    // Getters og setters
    //-------------------------------
    public int[] getCardDeck() {
        return cardDeck;
    }
}
