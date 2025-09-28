

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;

	private final String title;
    private Price price;

	public Movie (String title, int priceCode) {
		this.title 		= title;
        setPriceCode(priceCode);
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + priceCode);
        }
    }

    public int getPriceCode () {
		return price.getPriceCode();
	}


	public String getTitle () {
		return title;
	}

    double getCharge(int daysRented) {
        double price = 0;
        price = this.price.getCharge(daysRented);
        return price;
    }
}