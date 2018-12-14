
/**
* The RestaurantReview class creates the object type RestaurantReview.
*/
public class RestaurantReview {

	private String content;
	private int rating;
	private String restaurantUnderReview;
	private String[] vulgarWords = {"crappy", "stupid", "dumb", "idiot", "dummies", "loser", "fool", "ass", "imbecile"};
	
	/**
	 * Constructor for the RestaurantReview class. Initializes instance variable of name.
	 * @param the review content
	 * @param the rating of the restaurant
	 * @param the name of the restaurant under review
	 */
	public RestaurantReview(String content, int rating, String restaurantUnderReview) {
		this.content = content;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRestaurantUnderReview() {
		return restaurantUnderReview;
	}

	public void setRestaurantUnderReview(String restaurantUnderReview) {
		this.restaurantUnderReview = restaurantUnderReview;
	}
	
	/**
	 * Detemines whether a request should be approved or denied for vulgar content
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
	 * Converts the review to a string
	 * @return the String representation of the review
	 */
	public String toString() {
		String reviewString = "Review of " + restaurantUnderReview + ": " + content + "\n" + "Rating: " + rating + " stars";
		return reviewString;
	}
	
}
	
