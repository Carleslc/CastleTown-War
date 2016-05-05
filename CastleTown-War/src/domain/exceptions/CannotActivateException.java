package domain.exceptions;

public class CannotActivateException extends IllegalAccessException {
	
	private static final long serialVersionUID = 849727027497275893L;

	public CannotActivateException(String msg) {
		super(msg);
	}
	
	public CannotActivateException() {
		super("Card cannot be activated!");
	}
}
