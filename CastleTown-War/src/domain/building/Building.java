package domain.building;

import domain.player.Player;

public abstract class Building {
	
	private Player owner;
	
	public Building(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}
	
}
