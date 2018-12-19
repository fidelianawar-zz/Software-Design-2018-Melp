import static org.junit.Assert.*;
import org.junit.Test;
/*
* This class tests that a member is correctly blocked after submitting too many vulgar reviews.
**/
public class BlockedUserTest {

	/*
	* Tests that the number of vulgar posts is correctly incremented
	**/
	@SuppressWarnings("unused")
	@Test
	public void checkingNumOfVulgarPosts() {
		MelpMember newMember = new MelpMember("member1", "password123");
		RestaurantReview review1 = new RestaurantReview(newMember.getName(), "This place was terrible. The owner is extremely dumb", 1, "Rastall");
		RestaurantReview review2 = new RestaurantReview(newMember.getName(), "Very crappy service. This place is stupid", 1, "Wooglin's");
		RestaurantReview review3 = new RestaurantReview(newMember.getName(), "Don't come here. The workers are idiots", 1, "Preserve");
		RestaurantReview review4 = new RestaurantReview(newMember.getName(), "Everything about this place is dumb and I wish could rate it a 0", 1, "Benji's");
		for(int i = 0; i < 5; i++) {
			newMember.incrementVulgarPosts();
		}
		assertEquals(newMember.maxVulgarPosts(), true);
	}
	
	/*
	* Tests that a member's status can correctly be updated to blocked
	**/
	@Test
	public void blockingUser() {
		MelpMember newMember = new MelpMember("member1", "password123");
		for(int i = 0; i < 5; i++) {
			newMember.incrementVulgarPosts();
		}
		newMember.blockUser();
		assertEquals(newMember.getStatus(), false);
	}
	
}
