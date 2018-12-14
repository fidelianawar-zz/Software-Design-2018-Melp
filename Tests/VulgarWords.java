import static org.junit.Assert.*;

import org.junit.Test;

public class VulgarWords {

	@Test
	public void disapprovedReview() {
		String content;
		int rating;
		Restaurant restaurantUnderReview;
		RestaurantReview review = new RestaurantReview("This place was terrible. The owner is extremely dumb", 1, "Rastall");
		boolean test = review.approveRequest();
		assertEquals(test, false);
	}
	
	@Test
	public void approvedReview() {
		String content;
		int rating;
		Restaurant restaurantUnderReview;
		RestaurantReview review = new RestaurantReview("This place was great! I loved the food here.", 5, "The Preserve");
		boolean test = review.approveRequest();
		assertEquals(test, true);
	}

}
