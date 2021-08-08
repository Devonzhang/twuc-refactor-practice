package com.twu.refactoring;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getThisAmount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;

        }
        return thisAmount;
    }

    @Override
    public String toString() {
        return "\t" + movie.getTitle() + "\t"
                + getThisAmount() + "\n";
    }

    public int getFrequentRenterPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1 ? 2 : 1;
    }

}