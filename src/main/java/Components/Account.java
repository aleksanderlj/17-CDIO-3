//******************************************************************
//  Account.java        Author: Gruppe 17
//  Support til Player.java
//  Repræsenterer en spillers konto
//******************************************************************

package Components;

public class Account {
    private int balance;

    //-------------
    // Constructor
    //-------------
    public Account(int startBalance){
        balance = startBalance;
    }

    //-------------------------------------
    // Tilføjer penge til spillerens konto
    //-------------------------------------
    public void addMoney(int profit){
        balance += profit;
    }

    //-------------------------------
    // Getters og setters
    //-------------------------------
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
