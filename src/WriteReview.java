/**
* This class defines the command for users to write reviews.
*/
public class WriteReview implements Command {
	private String review;
	private int rating;
	private Restaurant restaurantUnderReview;
	
	/**
	* Constructor for WriteReview instances.
	* @param the restaurant review
	* @param the rating of the restaurant
	* @param the name of the restaurant under review
	*/
	public WriteReview(String review, int rating, Restaurant restaurantUnderReview) {
		this.review = review;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}

	/**
	* This method executes commands.
	* Not yet implemented
	*/
	public void execute() {
		
	}
	
	/**
	* This method undoes commands.
	* Not yet implemented
	*/
	public void undo() {
		
	}
	
}
