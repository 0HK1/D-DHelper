package com.ucsal.braodireito.DiceScreen;


import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ucsal.braodireito.R;

public class ButtonDiceValue implements DiceRoller {
    DiceGenerator grn = new GeneratorRandomNumber();

    @Override
    public void FragmentD4(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d4_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d4);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(4)))
                );
    }
    @Override
    public void FragmentD6(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d6_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d6);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(6)))
        );
    }
    @Override
    public void FragmentD8(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d8_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d8);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(8)))
        );
    }
    @Override
    public void FragmentD10(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d10_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d10);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(10)))
        );
    }
    @Override
    public void FragmentD12(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d12_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d12);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(12)))
        );
    }
    @Override
    public void FragmentD20(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d20_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d20);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(20)))
        );
    }
    @Override
    public void FragmentD100(Activity activity){
        FrameLayout frameLayout = activity.findViewById(R.id.frameLayout_d100_dice);
        TextView textView = activity.findViewById(R.id.button_value_dice_d100);
        frameLayout.setOnClickListener(view ->
                textView.setText(String.valueOf(grn.GeneratorNumber(100)))
        );
    }

    public void Fragment(Activity activity, int frameId, int textId, int faces) {
        FrameLayout frameLayout = activity.findViewById(frameId);
        TextView textView = activity.findViewById(textId);
        frameLayout.setOnClickListener(view ->
                textView.setText(grn.GeneratorNumber(faces))
        );
    }

}
