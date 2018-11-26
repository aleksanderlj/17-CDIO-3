package Components;

import java.util.Random;

public class Die {
    private int faceValue;
    private int faceAmount;

    //---------------------------
    //Constructor for Die klassen
    //---------------------------
    public Die(int faceAmount){
        this.faceAmount = faceAmount;
    }

    //-----------------------------------
    //Ruller terning og returner resultatet
    //-----------------------------------
    public int rul() {
        Random r = new Random();
        this.faceValue = r.nextInt(this.faceAmount) + 1;
        return this.faceValue;
    }

    //-------------------
    //Getters og setters
    //-------------------
    public int getFaceValue(){
        return this.faceValue;
    }

}