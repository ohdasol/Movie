package exception;

public class ProjectNotFoundException extends Exception{

	public  ProjectNotFoundException() {}
	
	public  ProjectNotFoundException(String msg) {
		super(msg);
	}
}
