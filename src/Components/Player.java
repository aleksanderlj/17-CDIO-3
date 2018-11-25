package Components;

import Fields.*;

public class Player {
    private String name;
    private Account account;
    private Property[] ownedProperties = new Property[16];

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
        for(int n=0 ; n == ownedProperties.length-1 "Mangler at ramme sidste index???" ; n++){
            if (ownedProperties[n] == sellProperty)
                addMoney(sellProperty.getValue());
                ownedProperties[n] = null;
                n = ownedProperties.length-1;
        }
    }

    public void removeAllProperties(){
        for(int n=0 ; n == ownedProperties.length-1 "Mangler at ramme sidste index???"; n++){
            ownedProperties[n] = null;
        }
    }

    public int getBalance(){
        return account.getBalance();
    }

    public void setBalance(int newBalance){
        account.setBalance(newBalance);
    }
}