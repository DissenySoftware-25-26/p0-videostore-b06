
import java.util.*;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = getTotalCharge();
        int frequentRenterPoints = getTotalFrequentRenterPoints();
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : this.rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + getAmountFor(rental) + "\n";
        }
        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += Rental.calculatePoints(rental);
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : this.rentals) {
            totalAmount += getAmountFor(rental);
        }
        return totalAmount;
    }

    private double getAmountFor(Rental rental) {
        return rental.getRentalPrice();
    }


}