package domain.exceptions;

public class DeckEmptyException extends IllegalAccessException {
	
	private static final long serialVersionUID = -2874023337016427878L;
	
	public DeckEmptyException(String msg) {
		super(msg);
	}
	
	public DeckEmptyException() {
		super("Deck is empty!");
	}
}
