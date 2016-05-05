package domain.cards.building;

import domain.player.Player;

public class Church extends UpgradableBuilding {
	
	public Church() {
		this(false);
	}
	
	public Church(boolean built) {
		super(Church.class.getSimpleName(), 5, 0, built);
	}
	
	public Church(String name, String description, int buildingCost, int effectCost, boolean built) {
		super(name, description, buildingCost, effectCost, built);
	}

	@Override
	protected void buildEffect() {
		owner.getTown().getChurches().add(this);
	}

	@Override
	protected void applyEffect(Player activator) {
		// TODO
	}

}
