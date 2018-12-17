import java.sql.SQLException;
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
	 * @param the owner of the restaurant
	 * @param the average rating of the restaurant
	 * @param the location of the restaurant
	 * @param the type of food of the restaurant
	 */
	public Restaurant(String name, String owner, int averageRating, String location, String typeOfFood) {
		this.name = name;
		this.owner = owner;
		this.averageRating = averageRating;
		this.location = location;
		this.typeOfFood = typeOfFood;
	}
	
	/**
	* Adds a review to the list of reviews
	* @param the current review to be added
	*/
	public String getReviews() {
		String output = null;
		for (int i = 0; i < reviews.size(); i++) {
			output += reviews.get(i).toString();
			output += "\n\n";
		}
		return output;
	}
	
	public void addReview(RestaurantReview curr_review) {
		reviews.add(curr_review);
	}
	
	/**
	* Converts the restaurant to a string
	* @return the String representation of the restaurant
	*/
	public String toString() {
		return "Restaurant: " + name + "\nOwner: " + owner + "\nLocation: " + location + "\nType of Food: " + typeOfFood + "\nAverage Rating: " + Integer.toString(averageRating);
	}
}
