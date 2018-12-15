/**
 * The Command interface defines the execute and undo methods for different commands.
 */
public interface Command {
	
	/**
	 *Executes a command
	 */
	public RestaurantReview execute();
	
	/**
	 *Undoes a command
	 */
	public RestaurantReview undo();
	
}
