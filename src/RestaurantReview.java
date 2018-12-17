import java.util.ArrayList;
import java.util.Date;

/**
* The RestaurantReview class creates the Object type RestaurantReview.
*/
public class RestaurantReview {
//	private Date dateReviewed;
	
    /**
    * Gets the content of the review
    * @return the content
    */
	public String getContent() {
		return content;
	}

    /**
    * Sets the content of the review
    * @param the content
    */
	public void setContent(String content) {
		this.content = content;
	}

    /**
    * Gets the rating of the review
    * @return the rating
    */
	public int getRating() {
		return rating;
	}

    /**
    * Sets the content of the review
    * @param the content
    */
	public void setRating(int rating) {
		this.rating = rating;
	}

    /**
    * Gets the restaurant name for the review
    * @return the restaurant name
    */
	public String getRestaurantUnderReview() {
		return restaurantUnderReview;
	}

    /**
    * Sets the restaurant name for the review
    * @param the restaurant name
    */
	public void setRestaurantUnderReview(String restaurantUnderReview) {
		this.restaurantUnderReview = restaurantUnderReview;
	}

	private String content;
	private int rating;
	private String restaurantUnderReview;
	private String reviewer;
	private String[] vulgarWords = {"crappy", "stupid", "dumb", "idiot", "idiots", "dummy", "dummies", "loser", "losers", "fool", "fools", "ass", "imbecile", "imbeciles"};
	
	/**
	 * Constructor for the RestaurantReview class. Initializes instance variable of name.
	 * @param the reviewer
	 * @param the review content
	 * @param the rating of the restaurant
	 * @param the name of the restaurant under review
	 */
	public RestaurantReview(String reviewer, String content, int rating, String restaurantUnderReview) {
		this.reviewer = reviewer;
		this.content = content;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
//		this.dateReviewed = new Date();
	}
	
	/**
	 * Determines whether a request should be approved or denied for vulgar content
	 * @return true if the request is approved
	 */
	public boolean approveRequest() {
		String[] words = content.split(" ");
		for(String word: words) {
			for(String vulgarWord: vulgarWords) {
				if(word.equalsIgnoreCase(vulgarWord)) {
					return false;
				}
			}
		}
		return true;	
	}
	
	/**
	 * Checks if a review is spam
	 * @return true if a review is not spam
	 * Still in progress
	 */
//	public boolean isNotSpam(MelpMember currentReviewer, String restaurantUnderReview) {
//		//if the current reviewer has not posted a review for this restaurant in 1 day
//		Date currentDate = new Date();
//		if(!currentReviewer.getMy_restaurants().contains(restaurantUnderReview)) {
//			//if date reviewed is before current date
//			if(dateReviewed.before(currentDate)) { 
//				return true;
//			}
//		}
//		return false;
//	}
	
    /**
    * Converts the review to a string
    * @return the String representation of the review
    */
	public String toString() {
		String reviewString = "Review of " + restaurantUnderReview + ": " + content + "\n" + "Rating: " + rating + " stars";
		return reviewString;
	}
	
}
	
