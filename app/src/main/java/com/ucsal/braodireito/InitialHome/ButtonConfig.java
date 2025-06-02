package com.ucsal.braodireito.InitialHome;

import android.app.Activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ucsal.braodireito.Dice.DiceActivity;
import com.ucsal.braodireito.R;

public class ButtonConfig implements ButtonView {
    public void setButtonCharacter(Activity activity) {
        Button buttonCharacter = activity.findViewById(R.id.button_CharacterSheet);
        buttonCharacter.setOnClickListener(view ->
                Toast.makeText(activity,"Character Sheet", Toast.LENGTH_SHORT).show()
        );
    }
    public void setButtonDice(Activity activity){
        Button buttonDice = activity.findViewById(R.id.button_Dice);
        buttonDice.setOnClickListener(view ->{
            Intent i = new Intent(activity, DiceActivity.class);
            activity.startActivity(i);
        }
        );
    }
    public void setButtonDamageCalculator(Activity activity){
        Button buttonDamageCalculator = activity.findViewById(R.id.button_DamageCalculator);
        buttonDamageCalculator.setOnClickListener(view ->
                Toast.makeText(activity, "Damage Calculator", Toast.LENGTH_SHORT).show()
        );
    }
    public void setButtonMaster(Activity activity){
        Button buttonMaster = activity.findViewById(R.id.button_master);
        buttonMaster.setOnClickListener(view ->
                Toast.makeText(activity, "Master", Toast.LENGTH_SHORT).show()
        );
    }
    public void setButtonConfiguration(Activity activity){
        ImageView buttonConfiguration = activity.findViewById(R.id.button_config);
        buttonConfiguration.setOnClickListener(view ->
                Toast.makeText(activity, "Configuration", Toast.LENGTH_SHORT).show()
        );
    }




}
