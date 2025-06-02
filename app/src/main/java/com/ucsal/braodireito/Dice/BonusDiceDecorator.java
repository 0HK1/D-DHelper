package com.ucsal.braodireito.Dice;

public class BonusDiceDecorator extends DiceDecorator{
    private int bonus;

    public BonusDiceDecorator(Dice decoratedDice, int bonus) {
        super(decoratedDice);
        this.bonus=bonus;
    }

    @Override
    public int generate() {
        int baseGenerate = super.generate();
        return baseGenerate + bonus;
    }
}
