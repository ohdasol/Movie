package exception;

public class ProjectNameDuplicationException extends Exception{

	public ProjectNameDuplicationException() {}
	
	public ProjectNameDuplicationException(String m) {
		super(m);
	}
}
