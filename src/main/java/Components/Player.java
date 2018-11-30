//******************************************************************
//  Player.java        Author: Gruppe 17
//
//  Repræsenterer en spiller
//******************************************************************

package Components;

import Fields.*;

public class Player {
    private Account account;
    private Field[] ownedProperties = new Property[16];
    private int position = 0;
    private boolean inPrison = false;
    private boolean releaseCard = false;
    private static int nextID = 0;
    private int id;

    //-------------
    // Constructor
    //-------------
    public Player(int startBalance){
        account = new Account(startBalance);
        id = nextID;
        nextID++;
    }

    //-------------------------------
    // Flytter spilleren
    //-------------------------------
    public void move(int spaces){
        position += spaces;
        if (position > 23)
            position = position - 23;
    }

    //-------------------------------------
    // Tilføjer penge til spillerens konto
    //-------------------------------------
    public void addMoney(int profit){
        account.addMoney(profit);
    }

    //-------------------------------------------
    // Tilføjer en grund til spillerens inventar
    //-------------------------------------------
    public void addProperty(Field newProperty){
        int nextIndex = 0;
        boolean propertyAdded = false;

        do{
            if(nextIndex != ownedProperties.length){
                if(ownedProperties[nextIndex] == null){
                    ownedProperties[nextIndex] = newProperty;
                    newProperty.setOwner(this);
                    propertyAdded = true;
                }
                else
                    nextIndex++;
            }
            else
                nextIndex = 0;
        }while(!propertyAdded);
    }

    //-----------------------------------------
    // Sælger en grund fra spillerens inventar
    //-----------------------------------------
    public void sellProperty(Property sellProperty){
        for(int n=0 ; n < ownedProperties.length; n++){
            if (ownedProperties[n] == sellProperty){
                addMoney(sellProperty.getValue());
                sellProperty.setOwner(null);
                ownedProperties[n] = null;
                n = ownedProperties.length; //For at komme hurtigt ud af loop
            }
        }
    }

    //---------------------------------------------
    // Fjerner alle grunde fra spillerens inventar
    //---------------------------------------------
    public void removeAllProperties(){
        for(int n=0 ; n < ownedProperties.length ; n++){
            ownedProperties[n].setOwner(null);
            ownedProperties[n] = null;
        }
    }

    //--------------------
    // Getters og setters
    //--------------------
    public int getBalance(){
        return account.getBalance();
    }

    public void setBalance(int newBalance){
        account.setBalance(newBalance);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getInPrison(){
        return inPrison;
    }

    public void setInPrison(boolean inPrison) {
        this.inPrison = inPrison;
    }

    public boolean getReleaseCard(){
        return releaseCard;
    }

    public void setReleaseCard(boolean releaseCard) {
        this.releaseCard = releaseCard;
    }

    public int getId() {
        return id;
    }
}