import java.io.IOException;
import java.sql.SQLException;
/**
 * The Command interface defines execute and undo methods for different commands.
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
	 * @throws SQLException 
	 */
	public void undo() throws IOException, SQLException;
	
}
