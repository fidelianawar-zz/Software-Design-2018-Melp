import java.util.ArrayList;

/**
 * The MelpMember class creates instances of Melp members.
 */
public class MelpMember{
	private String name;
	private String password;
	private MelpUserState currentState;
	private MelpUserState activeState;
	private MelpUserState blockedState;
	
	private ArrayList<RestaurantReview> my_reviews = new ArrayList<RestaurantReview>();
	private String image_path;
	private boolean memberStatus;
	private int numOfVulgarPosts;

	/**
	 * Constructor for the MelpMember class. Initializes instance variable of name.
	 * @param the name of the Melp member
	 */
	public MelpMember(String name, String password) {
		this.name = name;
	
		this.password = password;
		this.activeState = new MelpMemberActiveState();
		this.blockedState = new MelpMemberBlockedState();
		this.currentState = new MelpMemberActiveState();
		this.image_path = "";
	}
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImagePath(String path) {
		image_path = path;
	}
	
	public void addReviewToMyReviews(RestaurantReview new_review) {
		my_reviews.add(new_review);
	}

	public ArrayList<RestaurantReview> getMy_reviews() {
		return my_reviews;
	}
	
	public void deleteLastReview() {
		my_reviews.remove(my_reviews.size() - 1);
		System.out.println(my_reviews.remove(my_reviews.size() - 1));
	}
	
	public void setStatus(boolean memberStatus) {
		this.memberStatus = memberStatus;
	}

	public boolean getStatus() {
		return currentState.getStatus();
	}

	public int getNumOfVulgarPosts() {
		return numOfVulgarPosts;
	}

	public void incrementVulgarPosts() {
		numOfVulgarPosts++;
	}

	public boolean maxVulgarPosts() {
		return numOfVulgarPosts >= 20;
	}

	public void blockUser() {
		currentState = blockedState;
	}

}
