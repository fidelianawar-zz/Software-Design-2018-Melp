import java.util.ArrayList;

/**
 * The MelpMember class creates instances of Melp members.
 */
public class MelpMember{
	private String name;
	private String password;
	private MelpUserState currentState;
	@SuppressWarnings("unused")
	private MelpUserState activeState;
	private MelpUserState blockedState;
	private ArrayList<RestaurantReview> my_reviews = new ArrayList<RestaurantReview>();
	private ArrayList<String> my_restaurants = new ArrayList<String>();
	private String image_path;
	private int numOfVulgarPosts;
	@SuppressWarnings("unused")
	private boolean memberStatus;

	/**
	 * Constructor for the MelpMember class. Initializes instance variable of name.
	 * @param the name of the Melp member
	 * @param the password for the Melp member
	 */
	public MelpMember(String name, String password) {
		this.name = name;
		this.password = password;
		this.activeState = new MelpMemberActiveState();
		this.blockedState = new MelpMemberBlockedState();
		this.currentState = new MelpMemberActiveState();
		this.image_path = "https://data.whicdn.com/images/298844185/large.jpg?t=1507433077";
		this.numOfVulgarPosts = 0;
		this.memberStatus = true;
	}
	
	/**
	* Gets the name of the user
	* @return name
	*/
	public String getName() {
		return name;
	}

	/**
	* Gets the password of the user
	* @return password
	*/
	public String getPassword() {
		return password;
	}

	/**
	* Gets the image path of the user
	* @return image path
	*/
	public String getImage_path() {
		return image_path;
	}

	/**
	* Sets the image path of the user
	* @param image path
	*/
	public void setImagePath(String path) {
		image_path = path;
	}
	
	/**
	* Adds a review to the list of reviews
	* @param the new review to be added
	*/
	public void addReviewToMyReviews(RestaurantReview new_review) {
		my_reviews.add(new_review);
	}
	
	/**
	* Adds a restaurant to the list of restaurants
	* @param the new restaurant to be added
	*/
	public void addRestaurantToMyRestaurants(String new_restaurant) {
		my_restaurants.add(new_restaurant);
	}

	/**
	* Gets the ArrayList of reviews
	* @return the ArrayList of reviews
	*/
	public ArrayList<RestaurantReview> getMy_reviews() {
		return my_reviews;
	}
	
	/**
	* Gets the ArrayList of restaurants
	* @return the ArrayList of restaurants
	*/
	public ArrayList<String> getMy_restaurants() {
		return my_restaurants;
	}
	
	/**
	* Deletes the last review from the ArrayList of reviews
	* @return the review to be deleted
	*/
	public RestaurantReview deleteLastReview() {
		if (my_reviews.size() != 0) {
			RestaurantReview reviewToRemove = my_reviews.get(my_reviews.size() - 1);
			my_reviews.remove(my_reviews.size() - 1);
			return reviewToRemove;
		}
		else {
			return null;
		}
	}
	
	/**
	* Sets the status of the member
	* @param the status
	*/
	public void setStatus(boolean memberStatus) {
		this.memberStatus = memberStatus;
	}

	/**
	* Gets the status of the member
	* @return the status
	*/
	public boolean getStatus() {
		return currentState.getStatus();
	}

	/**
	* Gets the number of vulgar posts
	* @return the number of vulgar posts
	*/
	public int getNumOfVulgarPosts() {
		return numOfVulgarPosts;
	}

	/**
	* Increments the number of vulgar posts
	*/
	public void incrementVulgarPosts() {
		numOfVulgarPosts++;
	}

	/**
	* Checks if a member is at the maximum number of vulgar posts
	* @param true if the member has hit the maximum number of vulgar posts
	*/
	public boolean maxVulgarPosts() {
		return numOfVulgarPosts >= 5;
	}

	/**
	* Blocks a user with too many vulgar posts
	*/
	public void blockUser() {
		currentState = blockedState;
	}
}
