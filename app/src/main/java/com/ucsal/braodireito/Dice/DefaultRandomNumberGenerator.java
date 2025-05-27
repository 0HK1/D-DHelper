package com.ucsal.braodireito.Dice;

import java.util.Random;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate(int number) {
        number++;
        return random.nextInt(number);

    }
}

