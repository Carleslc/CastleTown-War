package domain.cards;

import domain.Activable;
import domain.exceptions.AlreadyActivatedException;
import domain.exceptions.CannotActivateException;
import domain.exceptions.CardNotInHandException;
import domain.exceptions.NotEnoughGoldException;
import domain.player.Player;

public abstract class Card implements Activable {
	
	private String name, description;
	protected boolean activated;
	protected int cost;
	
	public Card(String name, int cost) {
		this(name, name, cost);
	}
	
	public Card(String name, String description, int cost) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		activated = false;
	}
	
	@Override
	public void activate(Player activator) throws CannotActivateException {
		if (!activator.getHand().contains(this))
			throw new CardNotInHandException(this);
		if (activated)
			throw new AlreadyActivatedException();
		if (activator.getGold() < cost)
			throw new NotEnoughGoldException();
		applyEffect(activator);
		activated = true;
		activator.substractGold(cost);
	}
	
	protected abstract void applyEffect(Player activator) throws CannotActivateException;
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public int getEffectCost() {
		return cost;
	}
	
	public void reset() {
		activated = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activated ? 1231 : 1237);
		result = prime * result + cost;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (activated != other.activated)
			return false;
		if (cost != other.cost)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return name + " (" + cost + "G): " + description + (activated ? " [ALREADY USED]": "[AVAILABLE TO USE]");
	}
}
