package domain.cards.building;

public class Wall extends UpgradableBuilding {

	private int defenseBonus;
	
	public Wall() {
		this(false);
	}
	
	public Wall(boolean built) {
		this(Wall.class.getSimpleName(), 2, 0, 5, built);
	}
	
	public Wall(String name, int buildingCost, int effectCost, int defenseBonus, boolean built) {
		this(name, name, buildingCost, effectCost, defenseBonus, built);
	}
	
	public Wall(String name, String description, int buildingCost, int effectCost, int defenseBonus, boolean built) {
		super(name, description, buildingCost, effectCost, built);
		this.defenseBonus = defenseBonus;
	}

	@Override
	protected void buildEffect() {
		owner.getTown().getWalls().add(this);
		owner.addDefense(defenseBonus);
	}

	public int getDefenseBonus() {
		return defenseBonus;
	}

	public void setDefenseBonus(int defenseBonus) {
		if (isBuilt()) {
			if (defenseBonus > this.defenseBonus)
				owner.addDefense(defenseBonus - this.defenseBonus);
			else if (defenseBonus < this.defenseBonus)
				owner.decreaseDefense(this.defenseBonus - defenseBonus);
		}
		this.defenseBonus = defenseBonus;
	}
}
