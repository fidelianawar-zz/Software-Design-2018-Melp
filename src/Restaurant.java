import java.util.ArrayList;

/**
 * The Restaurant class creates instances of restaurants registered on the system.
 */
public class Restaurant {
	private String name;
	private String owner;
	private int averageRating;
	private String location;
	private String typeOfFood;
	private ArrayList<RestaurantReview> reviews = new ArrayList<RestaurantReview>();

	/**
	 * Constructor for the Restaurant class. Initializes instance variable of name.
	 * @param the name of the restaurant
	 */
	public Restaurant(String name, String owner, int averageRating, String location, String typeOfFood) {
		this.name = name;
		this.owner = owner;
		this.averageRating = averageRating;
		this.location = location;
		this.typeOfFood = typeOfFood;
	}
	
	public void addReview(RestaurantReview curr_review) {
		reviews.add(curr_review);
	}
	
	public String toString() {
		return "Restaurant: " + name + "\nOwner: " + owner + "\nLocation :" + location + "\nType of Food :" + typeOfFood + "\n + Average Rating :" + Integer.toString(averageRating);
	}
}
