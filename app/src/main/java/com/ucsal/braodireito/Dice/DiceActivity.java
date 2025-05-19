package com.ucsal.braodireito.Dice;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.ucsal.braodireito.R;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_activity);
        FactoryButtonDice buttonDice = new FactoryButtonDice();
        DiceGenerator diceGenerator = new GeneratorRandomNumber();

        buttonDice.buttonDice(this,R.string.D4, 4);
        buttonDice.buttonDice(this,R.string.D6, 6);
        buttonDice.buttonDice(this,R.string.D8, 8);
        buttonDice.buttonDice(this,R.string.D10, 10);
        buttonDice.buttonDice(this,R.string.D12, 12);
        buttonDice.buttonDice(this,R.string.D20, 20);
        buttonDice.buttonDice(this,R.string.D100, 100);


    }
}