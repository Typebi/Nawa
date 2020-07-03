package userManagement.exceptions;

public class PwdException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PwdException() {
		super();
	}
	public PwdException(String message) {
		super(message);
	}
}
