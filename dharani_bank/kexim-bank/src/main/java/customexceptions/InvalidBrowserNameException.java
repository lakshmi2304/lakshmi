package customexceptions;

public class InvalidBrowserNameException  extends Exception{
	
	public InvalidBrowserNameException() {
		super("Browser name is either firefox or chrome");
	}
}
