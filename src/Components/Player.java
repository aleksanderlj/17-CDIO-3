package Components;

import Fields.*;

public class Player {
    private String name;
    private Account account;
    private Property[] ownedProperties = new Property[16];
    private int position = 0;

    public Player(String name, int startBalance){
        this.name = name;
        account = new Account(startBalance);
    }

    public void addMoney(int profit){
        account.addMoney(profit);
    }

    public void addProperty(Property newProperty){
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

    public void removeAllProperties(){
        for(int n=0 ; n < ownedProperties.length ; n++){
            ownedProperties[n].setOwner(null);
            ownedProperties[n] = null;
        }
    }

    //--------------------
    // Getters og setters
    //--------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}