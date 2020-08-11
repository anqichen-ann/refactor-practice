package com.twu.refactoring;

import java.util.Arrays;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return (int) Arrays.stream(numbers).filter(num -> num%2 == 0).count();
    }

    public int countOdd() {
        return numbers.length-countEven();
    }

    public int countPositive() {
        return (int) Arrays.stream(numbers).filter(num -> num >= 0).count();
    }

    public int countNegative() {
        return numbers.length-countPositive();
    }
}
