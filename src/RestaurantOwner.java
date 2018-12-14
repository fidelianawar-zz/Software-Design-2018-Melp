/**
 * The RestaurantOwner class creates instances of restaurant owners.
 */
public class RestaurantOwner {
	private Restaurant restaurantOwned;
	private String name;
	
	/**
	 * Constructor for the RestaurantOwner class. Initializes instance variable of name of restaurant owned.
	 * @param the name of the restaurant owned by the owner
	 */
	public RestaurantOwner(Restaurant restaurantOwned) {
		this.restaurantOwned = restaurantOwned;
	}
	
}
