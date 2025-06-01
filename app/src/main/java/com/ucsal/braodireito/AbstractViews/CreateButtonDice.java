package com.ucsal.braodireito.AbstractViews;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ucsal.braodireito.Dice.BonusDiceDecorator;
import com.ucsal.braodireito.Dice.Dice;
import com.ucsal.braodireito.Dice.DiceDecorator;
import com.ucsal.braodireito.Dice.HistoryDiceDecorator;
import com.ucsal.braodireito.Dice.StandardDice;

import java.util.List;

public class CreateButtonDice implements ButtonDice {

    private Dice dice;
    private final UnitConverter converter;

    public CreateButtonDice(Dice randomGenerator, UnitConverter converter) {
        this.dice = randomGenerator;
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
            dice = new StandardDice(valueGeneratorNumber);
            dice = new HistoryDiceDecorator(dice);
            int result = dice.generate();
            textValue.SetValueText(String.valueOf(result));

            // 1) Encontre o HistoryDiceDecorator (se existir) na cadeia de "dice" atual:
            HistoryDiceDecorator historyDecorator = findHistoryDecorator(dice);

            if (historyDecorator != null) {
                // 2) Se não for nulo, recupera a lista de históricos:
                List<Integer> historico = historyDecorator.getHistory();

                // 3) Converte a lista para um texto legível:
                String textoHistorico;
                if (historico.isEmpty()) {
                    textoHistorico = "Ainda não houve rolagens registradas.";
                } else {
                    textoHistorico = TextUtils.join(", ", historico);
                    textoHistorico = "[ " + textoHistorico + " ]";
                }

                // 4) Exiba esse texto na sua UI.
                new AlertDialog.Builder(activity)
                        .setTitle("Histórico de Rolagens")
                        .setMessage(textoHistorico)
                        .setPositiveButton("OK", null)
                        .show();

                //   Ou simplesmente setar o texto num TextView já presente no layout:
                // TextView tv = findViewById(R.id.historyTextView);
                // tv.setText(textoHistorico);

            } else {
                // Se historyDecorator for nulo, significa que não há HistoryDiceDecorator na cadeia:
                Toast.makeText(activity, "Este dado não está registrando histórico.", Toast.LENGTH_SHORT).show();
            }

        });
        return frameLayout;

    }

    public static HistoryDiceDecorator findHistoryDecorator(Dice dice) {
        // 1) Se for exatamente um HistoryDiceDecorator, devolve-o.
        if (dice instanceof HistoryDiceDecorator) {
            return (HistoryDiceDecorator) dice;
        }

        // 2) Se for um decorator genérico (que sabemos herda de DiceDecorator),
        //    "desempacota" e tenta a chamada recursiva:
        if (dice instanceof DiceDecorator) {
            DiceDecorator decorator = (DiceDecorator) dice;
            return findHistoryDecorator(decorator.decoratedDice);
        }

        // 3) Se for um StandardDice puro (ou outro tipo de Dice que não seja HistoryDiceDecorator),
        //    então não existe histórico: devolve null.
        return null;
    }
}
