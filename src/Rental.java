
public class Rental {
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    static int calculatePoints(Rental rental) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;

        if (rental.movie.getPriceCode() == Movie.NEW_RELEASE && rental.daysRented > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    double getRentalPrice() {
        return movie.getCharge(daysRented);
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    private final Movie movie;
    private final int daysRented;

}