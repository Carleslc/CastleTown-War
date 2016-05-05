package domain.cards;

import domain.player.Player;

public abstract class Card {
	
	private String description;
	protected int cost;
	
	public Card(String description, int cost) {
		this.description = description;
		this.cost = cost;
	}
	
	public boolean activate(Player activator) {
		if (activator.getGold() < cost)
			return false;
		applyEffect(activator);
		activator.substractGold(cost);
		return true;
	}
	
	protected abstract void applyEffect(Player activator);

	public String getDescription() {
		return description;
	}

	public int getCost() {
		return cost;
	}
}
