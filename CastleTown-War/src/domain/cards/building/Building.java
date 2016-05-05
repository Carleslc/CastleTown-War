package domain.cards.building;

import domain.cards.Card;
import domain.exceptions.CannotActivateException;
import domain.exceptions.NotBuiltException;
import domain.exceptions.NotEnoughGoldException;
import domain.player.Player;

public abstract class Building extends Card {
	
	protected int buildingCost;
	protected Player owner;
	
	public Building(String name, int buildingCost, int effectCost) {
		this(name, name, buildingCost, effectCost, false);
	}
	
	public Building(String name, int buildingCost, int effectCost, boolean built) {
		this(name, name, buildingCost, effectCost, built);
	}
	
	public Building(String name, String description, int buildingCost, int effectCost) {
		this(name, description, buildingCost, effectCost, false);
	}
	
	protected Building(String name, String description, int buildingCost, int effectCost, boolean built) {
		super(name, description, effectCost);
		this.buildingCost = buildingCost;
		owner = null;
	}

	public void build(Player activator) throws NotEnoughGoldException {
		if (!isBuilt()) {
			if (activator.getGold() < buildingCost)
				throw new NotEnoughGoldException("Not enough gold to build this!");
			owner = activator;
			buildEffect();
			activator.substractGold(buildingCost);
		}
	}
	
	protected abstract void buildEffect();
	
	@Override
	public void activate(Player activator) throws CannotActivateException {
		if (!isBuilt())
			throw new NotBuiltException(this);
		super.activate(activator);
	}
	
	public boolean isBuilt() {
		return owner != null;
	}

	public int getBuildingCost() {
		return buildingCost;
	}
	
	public void setBuildingCost(int buildingCost) {
		this.buildingCost = buildingCost;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
