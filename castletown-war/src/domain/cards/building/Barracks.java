package domain.cards.building;

import domain.player.Player;

public class Barracks extends UpgradableBuilding {
	
	private int attackBonus;
	
	public Barracks() {
		this(false);
	}
	
	public Barracks(boolean built) {
		this(Barracks.class.getSimpleName(), 3, 1, 1, built);
	}
	
	public Barracks(String name, int buildingCost, int effectCost, int attackBonus, boolean built) {
		this(name, name, buildingCost, effectCost, attackBonus, built);
	}
	
	public Barracks(String name, String description, int buildingCost, int effectCost, int attackBonus, boolean built) {
		super(name, description, buildingCost, effectCost, built);
		this.attackBonus = attackBonus;
	}

	@Override
	public void applyEffect(Player activator) {
		activator.addAttack(attackBonus);
	}

	@Override
	protected void buildEffect() {
		owner.getTown().getBarracks().add(this);
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

}
