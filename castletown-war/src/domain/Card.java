package domain;


public abstract class Card {
	String description;
	int cost;
	public boolean activate(Player activator) {
		if(activator.getGold() < cost)
			return false;
		applyEffect(activator);
		activator.substractGold(cost);
		return true;
	}
	
	protected abstract void applyEffect(Player activator);
}
