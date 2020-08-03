package com.twu.refactoring;

public class NewRelease_Movie extends Movie{
    public NewRelease_Movie(String title) {
        super(title);
    }

    @Override
    double getAmount(int getDaysRented) {
        return getDaysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int getDaysRented) {
        return getDaysRented > 1? 2:1;
    }
}
