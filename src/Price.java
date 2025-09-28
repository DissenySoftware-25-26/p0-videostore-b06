abstract class Price {
    abstract int getPriceCode();
    abstract  double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented){ return 0;};
}
class ChildrensPrice extends Price {
    @Override
    double getCharge(int daysRented) {
        double price = 1.5;
        if (daysRented > 3)
            price += (daysRented - 3) * 1.5;
        return price;
    }
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}

class  RegularPrice extends Price {
    @Override
    double getCharge(int daysRented) {
        double price = 2;
        if (daysRented > 2)
            price += (daysRented - 2) * 1.5;
        return price;
    }
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}

class NewReleasePrice extends Price {
    @Override
    int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) return 1;
        else return 0;
    }
    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}