abstract class Price {
    abstract int getPriceCode();
    abstract  double getCharge(int daysRented);
}
class ChildrensPrice extends Price {
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
    double getCharge(int daysRented) {
        return daysRented * 3;
    }
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}