package com.ucsal.braodireito.Dice;

public abstract class DiceDecorator implements Dice{
    protected Dice decoratedDice;

    public DiceDecorator(Dice decoratedDice) {
        this.decoratedDice = decoratedDice;
    }
    @Override
    public int generate() {
        return decoratedDice.generate();
    }
}
