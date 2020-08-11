package com.twu.refactoring;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getAmount(int daysRented) {
        return movie.getAmount(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return movie.getFrequentRenterPoints(daysRented);
    }
}