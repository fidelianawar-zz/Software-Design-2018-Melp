/**
* This class defines the command to write reviews.
*/
public class WriteReview implements Command {
	private String review;
	private int rating;
	private Restaurant restaurantUnderReview;
	
	public WriteReview(String review, int rating, Restaurant restaurantUnderReview) {
		this.review = review;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}

	public void execute() {
		
	}
	
	public void undo() {
		
	}
	
}
