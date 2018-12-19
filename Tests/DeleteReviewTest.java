import static org.junit.Assert.*;
import org.junit.Test;

/*
* This class tests the deleteLastReview method in the MelpMember class
**/
public class DeleteReviewTest {

	/*
	* Tests that the last review input is deleted.
	**/
	@Test
	public void testDeleteLastReview() {
		MelpMember user = new MelpMember("default member", "passwordabc");
		RestaurantReview review1 = new RestaurantReview("default member", "I had a bad experience with the service.", 2, "Rastall");
		RestaurantReview review2 = new RestaurantReview("default member", "I enjoyed the food quality and had a nice and chatty waiter.", 4, "Preserve");
		RestaurantReview review3 = new RestaurantReview("default member", "Not enough selection - very few options.", 1, "Benji's");
		user.addReviewToMyReviews(review1);
		user.addReviewToMyReviews(review2);
		user.addReviewToMyReviews(review3);
		assertEquals(user.deleteLastReview(), review3);
	}
	
	/*
	* Tests that the last review input is deleted when one review is deleted.
	**/
	@Test
	public void testDeleteLastReviewTwice() {
		MelpMember user = new MelpMember("default member", "passwordabc");
		RestaurantReview review1 = new RestaurantReview("default member", "I had a bad experience with the service.", 2, "Rastall");
		RestaurantReview review2 = new RestaurantReview("default member", "I enjoyed the food quality and had a nice and chatty waiter.", 4, "Preserve");
		RestaurantReview review3 = new RestaurantReview("default member", "Not enough selection - very few options.", 1, "Benji's");
		user.addReviewToMyReviews(review1);
		user.addReviewToMyReviews(review2);
		user.addReviewToMyReviews(review3);
		user.deleteLastReview();
		assertEquals(user.deleteLastReview(), review2);
	}
	
	/*
	* Tests that the last review input is deleted when multiple reviews are deleted.
	**/
	@Test
	public void testDeleteLastReviewWhenNoReviews() {
		MelpMember user = new MelpMember("default member", "passwordabc");
		assertEquals(user.deleteLastReview(), null);
	}

}
