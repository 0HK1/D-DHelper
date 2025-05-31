package com.ucsal.braodireito.AbstractViews.Factory;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.ucsal.braodireito.AbstractViews.ButtonDice;
import com.ucsal.braodireito.Dice.DefaultRandomNumberGenerator;
import com.ucsal.braodireito.Dice.RandomNumberGenerator;
import com.ucsal.braodireito.R;

public class ListButtonDice {
    private final DiceFactory factory;

    public ListButtonDice(DiceFactory factory) {
        this.factory = factory;
    }
    public void createAllDiceButtons(Activity activity, ViewGroup container) {
        ButtonDice dice = factory.createDice();
        RandomNumberGenerator rng = new DefaultRandomNumberGenerator();


        int[] diceIds = {
                R.string.D4, R.string.D6, R.string.D8,
                R.string.D10, R.string.D12, R.string.D20, R.string.D100
        };

        int[] maxNumbers = {4, 6, 8, 10, 12, 20, 100};

        for (int i = 0; i < diceIds.length; i++) {
            View button = dice.buttonDice(activity, diceIds[i], maxNumbers[i]);
            container.addView(button);
        }
    }
}
