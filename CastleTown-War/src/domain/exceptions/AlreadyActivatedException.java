package domain.exceptions;

public class AlreadyActivatedException extends CannotActivateException {

	private static final long serialVersionUID = 9161407578249347415L;

	public AlreadyActivatedException(String msg) {
		super(msg);
	}

	public AlreadyActivatedException() {
		super("This card has already been activated. You cannot activate it yet.");
	}
}
