/**
* The RestaurantReview class
*/
public class RestaurantReview {
	private String content;
	private int rating;
	private Restaurant restaurantUnderReview;
	
	public RestaurantReview(String content, int rating, Restaurant restaurantUnderReview) {
		this.content = content;
		this.rating = rating;
		this.restaurantUnderReview = restaurantUnderReview;
	}
	
}
