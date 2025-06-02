package com.ucsal.braodireito.Dice;

import java.util.Random;

public class StandardDice implements Dice {
     private int faces;
    public StandardDice(int faces){
        this.faces = faces;
    }

    public StandardDice() {
        this(6);
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

    @Override
    public int generate() {
        return new Random().nextInt(faces+1);
    }
}

