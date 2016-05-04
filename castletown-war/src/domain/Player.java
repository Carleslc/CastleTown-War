package domain;

import domain.player.Hand;
import domain.player.Town;

public abstract class Player {
	String name;
	boolean isAlive;
	int life;
	int attackPool;
	int defensePool;
	int gold;
	Hand hand;
	Town town;
	
	public Player(String name){
		hand = new Hand();
		town = new Town(this);
		isAlive = true;
		life = 20;
		attackPool = 0;
		defensePool = 0;
		gold = 0;
	}
	public abstract void play();
	
	public boolean isAlive(){
		return life <= 0;
	}
	
	public int getGold(){
		return gold;
	}
	
	public void substractGold(int ammount){
		gold -= ammount;
	}
}
