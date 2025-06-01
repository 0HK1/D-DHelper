package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ucsal.braodireito.Dice.Dice;
import com.ucsal.braodireito.Dice.StandardDice;

public class CreateButtonDice implements ButtonDice {

    private final Dice randomGenerator;
    private final UnitConverter converter;

    public CreateButtonDice(Dice randomGenerator, UnitConverter converter) {
        this.randomGenerator = randomGenerator;
        this.converter = converter;
    }

    @Override
    public View buttonDice(Activity activity, int StringTitle, int valueGeneratorNumber) {
        TextButtonValue textValue = new TextButtonValue();


        // Criação do FrameLayout
        FrameLayout frameLayout = new FrameLayout(activity);
        LinearLayout.LayoutParams frameParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                converter.convert(activity, 57) // altura fixa igual ao XML
        );
        frameParams.topMargin = converter.convert(activity, 38);
        frameLayout.setLayoutParams(frameParams);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);

        // Adiciona os elementos ao FrameLayout
        frameLayout.addView(new BackgroundButton().Background(activity));
        frameLayout.addView(new TextButton().Text(activity, StringTitle));
        frameLayout.addView(textValue.ValueText(activity));

        // Implementa lógica do click com injeção de dependência
        frameLayout.setOnClickListener(view -> {
            randomGenerator.setFaces(valueGeneratorNumber);
            int result = randomGenerator.generate();
            textValue.SetValueText(String.valueOf(result));
        });
        return frameLayout;

    }
}
