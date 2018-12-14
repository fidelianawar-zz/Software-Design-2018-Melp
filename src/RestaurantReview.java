
/**
* The RestaurantReview class
*/
public class RestaurantReview {
	private String content;
	private int rating;
	private Restaurant restaurantUnderReview;
	private String[] vulgarWords = {"crappy", "stupid", "dumb", "idiot", "dummies", "loser", "fool", "ass", "imbecile"};
	
	public RestaurantReview(String content, int rating, Restaurant restaurantUnderReview) {
		this.content = content;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}
	
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
	
