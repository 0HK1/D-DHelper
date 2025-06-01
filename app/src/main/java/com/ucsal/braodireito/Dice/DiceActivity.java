package com.ucsal.braodireito.Dice;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ucsal.braodireito.AbstractViews.Factory.DefaultDiceFactory;
import com.ucsal.braodireito.AbstractViews.Factory.DiceFactory;
import com.ucsal.braodireito.AbstractViews.Factory.ListButtonDice;
import com.ucsal.braodireito.R;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_activity);


        LinearLayout linearLayout = findViewById(R.id.linearLayoutDice);
        DiceFactory factory = createFactory();
        ListButtonDice buttonManager = new ListButtonDice(factory);
        buttonManager.createAllDiceButtons(this, linearLayout);
    }

    private DiceFactory createFactory() {
        return new DefaultDiceFactory(new StandardDice());
    }
}
