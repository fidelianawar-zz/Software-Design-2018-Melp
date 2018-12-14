/**
 * The MelpMember class creates instances of Melp members.
 */
public class MelpMember {
	private String name;

	/**
	 * Constructor for the MelpMember class. Initializes instance variable of name.
	 * @param the name of the Melp member
	 */
	public MelpMember(String name) {
		this.name = name;
	}
	
	public RestaurantReview createReview(Restaurant restaurantUnderReview, String review, int rating) {
		return new RestaurantReview(review, rating, restaurantUnderReview);
	}
	
}
