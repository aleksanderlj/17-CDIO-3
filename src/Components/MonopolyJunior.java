package Components;

import Fields.Field;

public class MonopolyJunior {
    private static Board board  = new Board();

    static Player[] players = board.createPlayers();
    //Gætter på der skal laves en createPlayers metode
    static Field[] field = board.getFields();
    static int[] findWinner = new int[players.length];

    public static void main(String[] args) {
        board.createBoard();

        Die die = new Die(6);

        for (int n = 0;n < players.length;n++){
            while(players[n].getBalance() < 0){

                int roll = die.roll();

                players[n].move(roll);

                field[players[n].getPosition()].landOn(players[n]);

                if(n == players.length - 1){
                    n = 0;
                }
                if (players[n].getBalance() < 0){
                    endGame();
                }
            }
        }
    }

    public static void endGame(){
        for (int n = 0;n < players.length;n++){
            findWinner[n] = players[n].getBalance();
        }
        int max = getMax(findWinner);
        for(int n = 0;n < players.length;n++){
            if(max == players[n].getBalance()){
                players[n].win;
                //Lav en win metode
            }
        }
    }

    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int n = 1;n < inputArray.length;n++){
            if(inputArray[n] > maxValue){
                maxValue = inputArray[n];
            }
        }
        return maxValue;
    }

    public static Board getBoard(){
        return board;
    }
}
