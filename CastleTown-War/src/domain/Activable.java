package domain;

import domain.exceptions.CannotActivateException;
import domain.player.Player;

@FunctionalInterface
public interface Activable {

	void activate(Player activator) throws CannotActivateException;
	
}
