import static org.junit.Assert.*;
import org.junit.Test;
/*
* This class tests that spam is correctly managed in Melp.
**/
public class ManageSpamTests {

	/*
	* Tests that a non-spam review is not marked as spam
	**/
	@Test
	public void testNotSpam() {
		MelpMember newMember = new MelpMember("member1", "lovecomputers");
		RestaurantReview review = new RestaurantReview("member1", "It was alright - the food was pretty good and cheap and I would go back.", 3, "Preserve");
		assertEquals(review.isNotSpam(newMember, review.getRestaurantUnderReview()), true);
	}
	
	/*
	* Tests that a spam review is marked as spam when there is one review pre-existing
	**/
	@Test
	public void testSpam2Reviews() {
		MelpMember newMember = new MelpMember("member1", "lovecomputers");
		RestaurantReview review = new RestaurantReview("member1", "It was alright - the food was pretty good and cheap and I would go back.", 3, "Preserve");
		newMember.addRestaurantToMyRestaurants(review.getRestaurantUnderReview());
		RestaurantReview review2 = new RestaurantReview("member1", "I liked it a little better the second time.", 4, "Preserve");
		assertEquals(review2.isNotSpam(newMember, review2.getRestaurantUnderReview()), false);
	}
	
	/*
	* Tests that a spam review is marked as spam when there are two reviews pre-existing
	**/
	@Test
	public void testSpam3Reviews() {
		MelpMember newMember = new MelpMember("member2", "helloworld");
		RestaurantReview review = new RestaurantReview("member2", "I loved it.", 5, "Rastall");
		newMember.addRestaurantToMyRestaurants(review.getRestaurantUnderReview());
		RestaurantReview review2 = new RestaurantReview("member2", "Can't complain - the burgers were good. It would be nice if they had a few more options.", 4, "Benji's");
		newMember.addRestaurantToMyRestaurants(review2.getRestaurantUnderReview());
		RestaurantReview review3 = new RestaurantReview("member2", "Not as good as my first experience, but still decent.", 4, "Rastall");
		assertEquals(review3.isNotSpam(newMember, review3.getRestaurantUnderReview()), false);
	}
	
	/*
	* Tests that a non-spam review is not marked as spam when there are two reviews pre-existing
	**/
	@Test
	public void testNotSpam3Reviews() {
		MelpMember newMember = new MelpMember("member2", "helloworld");
		RestaurantReview review = new RestaurantReview("member2", "I loved it.", 5, "Rastall");
		newMember.addRestaurantToMyRestaurants(review.getRestaurantUnderReview());
		RestaurantReview review2 = new RestaurantReview("member2", "Can't complain - the burgers were good. It would be nice if they had a few more options.", 4, "Benji's");
		newMember.addRestaurantToMyRestaurants(review2.getRestaurantUnderReview());
		RestaurantReview review3 = new RestaurantReview("member2", "Wasn't my favorite. Good service though.", 2, "Wooglins");
		assertEquals(review3.isNotSpam(newMember, review3.getRestaurantUnderReview()), true);
	}
}
