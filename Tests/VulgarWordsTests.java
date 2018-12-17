import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests that the Restaurant Review class is correctly approving and disapproving reviews.
 */
public class VulgarWordsTests {

	/**
	 * Tests that a vulgar review is disapproved correctly
	 */
	@Test
	public void disapprovedReview() {
		RestaurantReview review = new RestaurantReview("member A", "This place was terrible. The owner is extremely dumb", 1, "Rastall");
		assertEquals(review.approveRequest(), false);
	}
	
	/**
	 * Tests that a non-vulgar review is approved
	 */
	@Test
	public void approvedReview() {
		RestaurantReview review = new RestaurantReview("member A", "This place was great! I loved the food here.", 5, "The Preserve");
		boolean test = review.approveRequest();
		assertEquals(test, true);
	}

}
