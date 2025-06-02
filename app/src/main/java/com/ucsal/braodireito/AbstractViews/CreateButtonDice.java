package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ucsal.braodireito.Dice.Dice;
import com.ucsal.braodireito.Dice.HistoryDiceDecorator;
import com.ucsal.braodireito.Dice.StandardDice;

public class CreateButtonDice implements ButtonDice {

    private Dice lastDice;
    private final UnitConverter converter;

    public CreateButtonDice(Dice randomGenerator, UnitConverter converter) {
        this.lastDice = randomGenerator;
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
            Dice dice = new StandardDice(valueGeneratorNumber);
            dice = new HistoryDiceDecorator(dice);
            int result = dice.generate();
            textValue.SetValueText(String.valueOf(result));
            this.lastDice = dice;

        });
        return frameLayout;
    }

    public Dice getLastDiceCreated() {
        return lastDice;
    }

}
