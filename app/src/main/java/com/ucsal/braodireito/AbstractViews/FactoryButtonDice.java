package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ucsal.braodireito.Dice.RandomNumberGenerator;
import com.ucsal.braodireito.R;

public class FactoryButtonDice implements ButtonDice {

    private final RandomNumberGenerator randomGenerator;

    public FactoryButtonDice(RandomNumberGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public View buttonDice(Activity activity, int StringTitle, int valueGeneratorNumber) {
        DpToDx converter = new DpToDx();
        TextButtonValue textValue = new TextButtonValue();
        LinearLayout linearLayout = activity.findViewById(R.id.linearLayoutDice);

        // Criação do FrameLayout
        FrameLayout frameLayout = new FrameLayout(activity);
        LinearLayout.LayoutParams frameParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                converter.ConverterDpToPx(activity, 57) // altura fixa igual ao XML
        );
        frameParams.topMargin = converter.ConverterDpToPx(activity, 38);
        frameLayout.setLayoutParams(frameParams);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);

        // Adiciona os elementos ao FrameLayout
        frameLayout.addView(new BackgroundButton().Background(activity));
        frameLayout.addView(new TextButton().Text(activity, StringTitle));
        frameLayout.addView(textValue.ValueText(activity));

        // Implementa lógica do click com injeção de dependência
        frameLayout.setOnClickListener(view -> {


            int result = randomGenerator.generate(valueGeneratorNumber);
            textValue.SetValueText(String.valueOf(result));


        });

        // Adiciona o FrameLayout ao LinearLayout
        linearLayout.addView(frameLayout);
        return frameLayout;
    }
}
