
public class Rental {
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    static int calculatePoints(Rental rental) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;

        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                && rental.getDaysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    double getRentalPrice() {
        double price = 0;

        // determines the amount for each line
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                price += 2;
                if (this.getDaysRented() > 2)
                    price += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                price += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                price += 1.5;
                if (this.getDaysRented() > 3)
                    price += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return price;
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