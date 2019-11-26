package dong.security.exception;

public class UnAuthorizedException extends RuntimeException {

	private static final long serialVersionUID = -8138146061258197919L;

	public UnAuthorizedException(String message) {
		super(message);
	}

}
