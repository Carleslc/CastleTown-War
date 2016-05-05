package domain.exceptions;

public class DeckEmptyException extends IllegalAccessException {
	
	private static final long serialVersionUID = 2215502724617471416L;

	public DeckEmptyException(String msg) {
		super(msg);
	}
	
	public DeckEmptyException() {
		super("Deck is empty!");
	}
}
