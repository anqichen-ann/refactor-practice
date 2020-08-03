package com.twu.refactoring;

public class Regular_Movie extends Movie{


    public Regular_Movie(String title) {
        super(title);
    }

    @Override
    double getAmount(int getDaysRented) {
        double amount = 2;
        if (getDaysRented > 2)
            amount += (getDaysRented - 2) * 1.5;
        return amount;
    }

    @Override
    int getFrequentRenterPoints(int getDaysRented) {
        return 1;
    }
}
