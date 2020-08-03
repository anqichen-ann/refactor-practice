package com.twu.refactoring;

public class Children_Movie extends Movie{
    public Children_Movie(String title) {
        super(title);
    }

    @Override
    double getAmount(int getDaysRented) {
        double amount = 1.5;
        if (getDaysRented > 3)
            amount += (getDaysRented - 3) * 1.5;
        return amount;
    }

    @Override
    int getFrequentRenterPoints(int getDaysRented) {
        return 1;
    }
}
