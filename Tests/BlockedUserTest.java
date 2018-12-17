import static org.junit.Assert.*;
import org.junit.Test;

public class BlockedUserTest {

	@Test
	public void checkingNumOfVulgarPosts() {
		MelpMember newMember = new MelpMember("member1", "password123");
		RestaurantReview review1 = new RestaurantReview("This place was terrible. The owner is extremely dumb", 1, "Rastall");
		RestaurantReview review2 = new RestaurantReview("Very crappy service. This place is stupid", 1, "Wooglin's");
		RestaurantReview review3 = new RestaurantReview("Don't come here. The workers are idiots", 1, "Preserve");
		RestaurantReview review4 = new RestaurantReview("Everything about this place is dumb and I wish could rate it a 0", 1, "Benji's");
		for(int i = 0; i < 5; i++) {
			newMember.incrementVulgarPosts();
		}
		assertEquals(newMember.maxVulgarPosts(), true);
	}
	
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
