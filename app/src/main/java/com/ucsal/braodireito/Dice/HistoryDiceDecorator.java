package com.ucsal.braodireito.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryDiceDecorator extends DiceDecorator {
    private static final List<Integer> history = new ArrayList<>();

    public HistoryDiceDecorator(Dice decoratedDice) {
        super(decoratedDice);
    }

    @Override
    public int generate() {
        int result = super.generate();
        history.add(result);
        return result;
    }

    public static List<Integer> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
