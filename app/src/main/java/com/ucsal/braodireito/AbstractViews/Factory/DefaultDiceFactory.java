package com.ucsal.braodireito.AbstractViews.Factory;


import com.ucsal.braodireito.AbstractViews.ButtonDice;
import com.ucsal.braodireito.AbstractViews.CreateButtonDice;
import com.ucsal.braodireito.AbstractViews.DpToDx;
import com.ucsal.braodireito.AbstractViews.DpToDxAdapter;
import com.ucsal.braodireito.AbstractViews.UnitConverter;
import com.ucsal.braodireito.Dice.RandomNumberGenerator;


public class DefaultDiceFactory extends DiceFactory {

    private final RandomNumberGenerator generator;

    public DefaultDiceFactory(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public ButtonDice createDice() {
        UnitConverter adapter = new DpToDxAdapter(new DpToDx());
        return new CreateButtonDice(generator, adapter);
    }

}
