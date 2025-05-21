package com.ucsal.braodireito.Dice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ucsal.braodireito.AbstractViews.ButtonDice;
import com.ucsal.braodireito.AbstractViews.ButtonDiceService;
import com.ucsal.braodireito.AbstractViews.FactoryButtonDice;
import com.ucsal.braodireito.R;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_activity);
        RandomNumberGenerator rng = new DefaultRandomNumberGenerator();
        ButtonDice factory = new FactoryButtonDice(rng);
        ButtonDiceService diceService = new ButtonDiceService(factory);

        diceService.getButtonDice().buttonDice(this, R.string.D4, 4);
        diceService.getButtonDice().buttonDice(this, R.string.D6, 6);
        diceService.getButtonDice().buttonDice(this, R.string.D8, 8);
        diceService.getButtonDice().buttonDice(this, R.string.D10, 10);
        diceService.getButtonDice().buttonDice(this, R.string.D12, 12);
        diceService.getButtonDice().buttonDice(this, R.string.D20, 20);
        diceService.getButtonDice().buttonDice(this, R.string.D100, 100);


    }
}