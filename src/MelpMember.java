import java.util.ArrayList;

/**
 * The MelpMember class creates instances of Melp members.
 */
public class MelpMember{
	private String name;
	private String password;
	private ArrayList<RestaurantReview> my_reviews = new ArrayList<RestaurantReview>();
	private String image_path;

	/**
	 * Constructor for the MelpMember class. Initializes instance variable of name.
	 * @param the name of the Melp member
	 */
	public MelpMember(String name, String password) {
		this.name = name;
		this.password = password;
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
	
}
