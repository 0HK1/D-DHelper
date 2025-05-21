package com.ucsal.braodireito.Dice;

public class NumberService {
    private final RandomNumberGenerator generator;

    public NumberService(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public int getRandomNumber(int number) {
        return generator.generate(number);
    }
}
