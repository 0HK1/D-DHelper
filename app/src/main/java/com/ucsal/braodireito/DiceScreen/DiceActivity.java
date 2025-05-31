package com.ucsal.braodireito.DiceScreen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ucsal.braodireito.R;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dice_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DiceRoller diceRoller = new ButtonDiceValue();
        diceRoller.FragmentD4(this);
        diceRoller.FragmentD6(this);
        diceRoller.FragmentD8(this);
        diceRoller.FragmentD10(this);
        diceRoller.FragmentD12(this);
        diceRoller.FragmentD20(this);
        diceRoller.FragmentD100(this);


    }
}