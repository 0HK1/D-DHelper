package com.ucsal.braodireito.Dice;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ucsal.braodireito.AbstractViews.Factory.DefaultDiceFactory;
import com.ucsal.braodireito.AbstractViews.Factory.DiceFactory;
import com.ucsal.braodireito.AbstractViews.Factory.ListButtonDice;
import com.ucsal.braodireito.R;

import java.util.List;

public class DiceActivity extends AppCompatActivity {
    private Dice diceWithHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_activity);

        LinearLayout linearLayout = findViewById(R.id.linearLayoutDice);
        DiceFactory factory = createFactory();
        ListButtonDice buttonManager = new ListButtonDice(factory);
        buttonManager.createAllDiceButtons(this, linearLayout);

        Button historyBtn = findViewById(R.id.btnHistory);
        historyBtn.setOnClickListener(v -> {
            HistoryDiceDecorator historyDecorator = findHistoryDecorator(diceWithHistory);
            showHistory(historyDecorator);
        });
    }

    private DiceFactory createFactory() {
        Dice dice = new StandardDice();
        dice = new HistoryDiceDecorator(dice);
        this.diceWithHistory = dice;
        return new DefaultDiceFactory(dice);
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

    public void showHistory(HistoryDiceDecorator historyDecorator) {
        if (historyDecorator != null) {
            List<Integer> historico = historyDecorator.getHistory();
            String textoHistorico;
            if (historico.isEmpty()) {
                textoHistorico = "Ainda não houve rolagens registradas.";
            } else {
                textoHistorico = TextUtils.join(", ", historico);
                textoHistorico = "[ " + textoHistorico + " ]";
            }
            new AlertDialog.Builder(this)
                    .setTitle("Histórico de Rolagens")
                    .setMessage(textoHistorico)
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            Toast.makeText(this, "Este dado não está registrando histórico.", Toast.LENGTH_SHORT).show();
        }
    }
}

