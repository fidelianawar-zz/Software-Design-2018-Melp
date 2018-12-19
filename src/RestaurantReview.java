import java.util.ArrayList;

/**
* The RestaurantReview class creates the Object type RestaurantReview for Melp.
*/
public class RestaurantReview {
	
	private String content;
	private int rating;
	private String restaurantUnderReview;
	private String reviewer;
	private String[] vulgarWords = {"crappy", "stupid", "dumb", "idiot", "idiots", "dummy", "dummies", "loser", "losers", "fool", "fools", "ass", "imbecile", "imbeciles", "shit", "shitty", "damn", "bitch"};
	
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
	}
	
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
	
	/**
	 * Gets a reviewer
	 * @return the current review
	 */
	public String getReviewer() {
		return reviewer;
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
	 * Checks if a review is spam - a review is spam if the reviewer has previously reviewed that restaurant already
	 * @param the current member writing the review
	 * @param the name of the restaurant under review
	 * @return true if a review is not spam
	 */
	public boolean isNotSpam(MelpMember currentReviewer, String restaurantUnderReview) {
		ArrayList<String> currentReviewerRestaurants = currentReviewer.getMy_restaurants();
		if(!currentReviewerRestaurants.contains(restaurantUnderReview)) {
				return true;
		}
		else {
			return false;
		}
	}
	
    /**
    * Gets String representation of the review without the member included
    * @return the String representation of the review without the member included
    */
	public String getReviewsWithoutMember() {
		String reviewString = "Reviewed " + restaurantUnderReview + ": " + content + "\n" + "Rating: " + rating + " stars";
		return reviewString;
	}
	
    /**
    * Converts the review to a string
    * @return the String representation of the review
    */
	public String toString() {
		String reviewString = reviewer + " reviewed " + restaurantUnderReview + ": " + content + "\n" + "Rating: " + rating + " stars";
		return reviewString;
	}
	
}
	
