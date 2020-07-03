package userManagement.exceptions;

public class NickException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NickException() {
		super();
	}
	public NickException(String message) {
		super(message);
	}
}