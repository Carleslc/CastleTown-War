package domain.exceptions;

import domain.cards.Card;

public class CardNotInHandException extends CannotActivateException {

	private static final long serialVersionUID = 7403906423998594879L;

	public CardNotInHandException(String msg) {
		super(msg);
	}
	
	public CardNotInHandException() {
		super("You don't have this card in your hand!");
	}
	
	public CardNotInHandException(Card c) {
		super(c.getName() + " is not in your hand!");
	}
}
