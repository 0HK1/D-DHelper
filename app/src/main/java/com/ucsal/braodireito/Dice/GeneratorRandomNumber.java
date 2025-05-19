package com.ucsal.braodireito.Dice;

import com.ucsal.braodireito.Dice.DiceGenerator;

import java.util.Random;

public class GeneratorRandomNumber implements DiceGenerator {
    Random rm = new Random();

    @Override
    public int GeneratorNumber(int number){
        number++;
        return rm.nextInt(number);
    }
}
