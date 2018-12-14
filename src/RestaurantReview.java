
/**
* The RestaurantReview class creates the type RestaurantReview.
*/
public class RestaurantReview {
	private String content;
	private int rating;
	private Restaurant restaurantUnderReview;
	private String[] vulgarWords = {"crappy", "stupid", "dumb", "idiot", "dummies", "loser", "fool", "ass", "imbecile"};
	
	/**
	 * Constructor for the RestaurantReview class. Initializes instance variable of name.
	 * @param the review content
	 * @param the rating of the restaurant
	 * @param the name of the restaurant under review
	 */
	public RestaurantReview(String content, int rating, Restaurant restaurantUnderReview) {
		this.content = content;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}
	
	/**
	 * Detemines whether a request should be approved or denied for vulgarity
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
	
}
	
