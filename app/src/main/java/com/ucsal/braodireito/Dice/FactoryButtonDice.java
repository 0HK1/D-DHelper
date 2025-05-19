package com.ucsal.braodireito.Dice;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.ucsal.braodireito.R;

public class FactoryButtonDice {

    public void buttonDice(Activity activity, int StringTitle, int valueGeneratorNumber) {
        LinearLayout linearLayout = activity.findViewById(R.id.linearLayoutDice);

        // Criação do FrameLayout
        FrameLayout frameLayout = new FrameLayout(activity);
        LinearLayout.LayoutParams frameParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dpToPx(activity, 57) // altura fixa igual ao XML
        );
        frameParams.topMargin = dpToPx(activity, 38);
        frameLayout.setLayoutParams(frameParams);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);

        // Imagem de fundo
        ImageView backgroundImage = new ImageView(activity);
        backgroundImage.setImageResource(R.drawable.button_dice_background);
        backgroundImage.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );
        backgroundImage.setLayoutParams(imageParams);

        // Texto do Número de Dados
        TextView titleText = new TextView(activity);
        titleText.setText(activity.getString(StringTitle));
        titleText.setTextSize(36);
        titleText.setTextColor(ContextCompat.getColor(activity, R.color.black));
        Typeface typeface = ResourcesCompat.getFont(activity, R.font.jim_nightshade);
        if (typeface != null) {
            titleText.setTypeface(typeface);
        }
        FrameLayout.LayoutParams titleParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        titleParams.gravity = Gravity.START | Gravity.CENTER_VERTICAL;
        titleParams.setMarginStart(dpToPx(activity, 12));
        titleText.setLayoutParams(titleParams);

        // Texto do valor do Dado
        TextView valueText = new TextView(activity);
        valueText.setText("");
        valueText.setMinWidth(dpToPx(activity, 56));
        valueText.setMinHeight(dpToPx(activity, 40));
        valueText.setGravity(Gravity.CENTER);
        valueText.setBackgroundResource(R.drawable.button_dice_value);
        valueText.setTextColor(ContextCompat.getColor(activity, R.color.black));
        FrameLayout.LayoutParams valueParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        valueParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
        valueParams.setMarginEnd(dpToPx(activity, 16));
        valueText.setLayoutParams(valueParams);

        // Adiciona os elementos ao FrameLayout
        frameLayout.addView(backgroundImage);
        frameLayout.addView(titleText);
        frameLayout.addView(valueText);

        // Implementa Lógica do Click
        frameLayout.setOnClickListener(view -> {
            DiceGenerator diceGenerator = new GeneratorRandomNumber();
            int result = diceGenerator.GeneratorNumber(valueGeneratorNumber);
            valueText.setText(String.valueOf(result));
        });


        // Adiciona o FrameLayout ao LinearLayout
        linearLayout.addView(frameLayout);
    }

    private int dpToPx(Activity activity, int dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                activity.getResources().getDisplayMetrics()
        );
    }
}
