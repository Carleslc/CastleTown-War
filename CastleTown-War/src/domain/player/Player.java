package domain.player;

public abstract class Player {
	
	private String name;
	private int life;
	private int attackPool;
	private int defensePool;
	private int gold;
	
	protected Hand hand;
	protected Town town;
	
	public Player(String name) {
		this.name = name;
		hand = new Hand();
		town = new Town(this);
		life = 20;
		attackPool = defensePool = gold = 0;
	}
	
	public abstract void play();
	
	public int getGold() {
		return gold;
	}
	
	public void addGold(int amount) {
		gold += amount;
	}
	
	/**
	 * Substract an amount of gold to this player.
	 * @param amount amount of gold to substract.
	 * @return the number of gold substracted (useful when amount > gold)
	 */
	public int substractGold(int amount) {
		if (amount > gold) {
			int goldSubstracted = gold;
			gold = 0;
			return goldSubstracted;
		}
		gold -= amount;
		return amount;
	}

	public String getName() {
		return name;
	}

	public int getLife() {
		return life;
	}
	
	public boolean isAlive() {
		return life > 0;
	}
	
	/**
	 * Substract an amount of life to this player.
	 * @param amount amount of life to substract.
	 * @return the number of life substracted (useful when amount > life)
	 */
	public int damage(int amount) {
		if (amount > life) {
			int lifeSubstracted = life;
			life = 0;
			return lifeSubstracted;
		}
		life -= amount;
		return amount;
	}

	public int getAttack() {
		return attackPool;
	}
	
	public void addAttack(int amount) {
		attackPool += amount;
	}
	
	/**
	 * Substract an amount of attack to this player.
	 * @param amount amount of attack to substract.
	 * @return the number of attack substracted (useful when amount > attack)
	 */
	public int decreaseAttack(int amount) {
		if (amount > attackPool) {
			int attackSubstracted = attackPool;
			attackPool = 0;
			return attackSubstracted;
		}
		attackPool -= amount;
		return amount;
	}
	
	public int getDefense() {
		return defensePool;
	}
	
	public void addDefense(int amount) {
		defensePool += amount;
	}
	
	/**
	 * Substract an amount of defense to this player.
	 * @param amount amount of defense to substract.
	 * @return the number of defense substracted (useful when amount > defense)
	 */
	public int decreaseDefense(int amount) {
		if (amount > defensePool) {
			int defenseSubstracted = defensePool;
			defensePool = 0;
			return defenseSubstracted;
		}
		defensePool -= amount;
		return amount;
	}

	public Hand getHand() {
		return hand;
	}

	public Town getTown() {
		return town;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return name.toUpperCase()
			+ "\nLife: " + life
			+ "\nAttack: " + attackPool
			+ "\nDefense: " + defensePool
			+ "\nGold: " + gold
			+ "\nHand: " + hand
			+ "\nTown\n----\n" + town;
	}
}
