/**
* This class defines the command for users to write reviews.
*/
public class WriteReview implements Command {
	private String review;
	private int rating;
	private String restaurantUnderReview;
	
	/**
	* Constructor for WriteReview instances.
	* @param the restaurant review
	* @param the rating of the restaurant
	* @param the name of the restaurant under review
	*/
	public WriteReview(String review, int rating, String restaurantUnderReview) {
		this.review = review;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}

	/**
	* This method executes commands.
	* Not yet implemented
	*/
	public RestaurantReview execute() {
		RestaurantReview new_review = new RestaurantReview(review, rating, restaurantUnderReview);
    	return new_review;
	}
	
	/**
	* This method undoes commands.
	* Not yet implemented
	*/
	public RestaurantReview undo() {
		RestaurantReview default_review = new RestaurantReview("Review no longer exists.", 0, restaurantUnderReview);
    	return default_review;
	}
	
}
