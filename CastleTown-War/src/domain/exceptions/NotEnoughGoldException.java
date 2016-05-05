package domain.exceptions;

public class NotEnoughGoldException extends CannotActivateException {
	
	private static final long serialVersionUID = 2714852812917406938L;

	public NotEnoughGoldException(String msg) {
		super(msg);
	}

	public NotEnoughGoldException() {
		super("Not enough gold to activate this card!");
	}
}
