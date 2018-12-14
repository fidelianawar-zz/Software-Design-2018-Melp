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
	
	/**
	* This method executes commands.
	* @param the name of the restaurant under review review
	* @param the review of the restaurant
	* @param the rating of the restaurant
	* @return the review of the restaurant object
	*/
	public RestaurantReview createReview(String restaurantUnderReview, String review, int rating) {
		return new RestaurantReview(review, rating, restaurantUnderReview);
	}
	
}
