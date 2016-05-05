package domain.exceptions;

import domain.cards.building.Building;

public class NotBuiltException extends CannotActivateException {
	
	private static final long serialVersionUID = 8896662824040179627L;

	public NotBuiltException(String msg) {
		super(msg);
	}
	
	public NotBuiltException() {
		super("Building not built yet!");
	}
	
	public NotBuiltException(Building type) {
		super(type.getClass().getSimpleName() + " not built yet!");
	}
}
