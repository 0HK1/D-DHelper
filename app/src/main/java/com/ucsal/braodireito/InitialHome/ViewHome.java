package com.ucsal.braodireito.InitialHome;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.ucsal.braodireito.R;

public class ViewHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_home);

        ButtonConfig buttonConfig = new ButtonConfig();

        buttonConfig.setButtonCharacter(this);
        buttonConfig.setButtonConfiguration(this);
        buttonConfig.setButtonDice(this);
        buttonConfig.setButtonDamageCalculator(this);
        buttonConfig.setButtonMaster(this);

    }


}
