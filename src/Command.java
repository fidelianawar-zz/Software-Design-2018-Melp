import java.io.IOException;
/**
 * The Command interface defines the execute and undo methods for different commands.
 */
public interface Command {
	
	/**
	 * Executes a command
	 * @throws IOException
	 */
	public void execute() throws IOException;
	
	/**
	 * Undoes a command
	 * @throws IOException
	 */
	public void undo() throws IOException;
	
}
