/**
* This class defines a Melp member in an active state.
*/
public class MelpMemberActiveState implements MelpUserState {
	
	/**
	* Gets the status of the user
	* @return true if the user is active
	*/
	public boolean getStatus() {
		return true;
	}
}
