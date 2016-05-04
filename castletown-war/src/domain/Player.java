package domain;

public class Player {
	boolean isAlive;
	int life;
	int attackPool;
	int defensePool;
	int gold;
	Hand hand;
	Town town;
	public Player(){
		hand = new Hand();	
		isAlive = true;
		life = 20;
		attackPool = 0;
		defensePool = 0;
		gold = 0;
	}
}
