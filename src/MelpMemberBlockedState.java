/**
* This class defines a Melp member in a blocked state.
*/
public class MelpMemberBlockedState implements MelpUserState {
	
	/**
	* Gets the status of the user
	* @return false if the user is blocked
	*/
	public boolean getStatus() {
		return false;
	}
}
