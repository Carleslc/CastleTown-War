package domain.cards.building;

import domain.player.Player;

public class Mine extends UpgradableBuilding {
	
	private int goldBonus;
	
	public Mine() {
		this(false);
	}
	
	public Mine(boolean built) {
		this(Mine.class.getSimpleName(), 3, 0, 1, built);
	}
	
	public Mine(String name, int buildingCost, int effectCost, int goldBonus, boolean built) {
		this(name, name, buildingCost, effectCost, goldBonus, built);
	}
	
	public Mine(String name, String description, int buildingCost, int effectCost, int goldBonus, boolean built) {
		super(name, description, buildingCost, effectCost, built);
		this.goldBonus = goldBonus;
	}

	@Override
	protected void applyEffect(Player activator) {
		activator.addGold(goldBonus);
	}

	@Override
	protected void buildEffect() {
		owner.getTown().getMines().add(this);
	}

	public int getGoldBonus() {
		return goldBonus;
	}

	public void setGoldBonus(int goldBonus) {
		this.goldBonus = goldBonus;
	}
	
}
