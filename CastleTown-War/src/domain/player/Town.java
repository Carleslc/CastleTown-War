package domain.player;

import java.util.ArrayList;

import domain.cards.building.Barracks;
import domain.cards.building.Church;
import domain.cards.building.Mine;
import domain.cards.building.Wall;

public class Town {
	
	private Player owner;
	private ArrayList<Mine> mines;
	private ArrayList<Barracks> barracks;
	private ArrayList<Wall> walls;
	private ArrayList<Church> churches;
	
	public Town(Player owner) {
		this.owner = owner;
		
		mines = new ArrayList<>();
		mines.add(new Mine(true));
		
		barracks = new ArrayList<>();
		barracks.add(new Barracks(true));
		
		churches = new ArrayList<>();
		churches.add(new Church(true));
	}

	public Player getOwner() {
		return owner;
	}
	
	public ArrayList<Mine> getMines() {
		return mines;
	}
	
	public ArrayList<Barracks> getBarracks() {
		return barracks;
	}

	public ArrayList<Wall> getWalls() {
		return walls;
	}

	public ArrayList<Church> getChurches() {
		return churches;
	}

	@Override
	public String toString() {
		return "Barracks: " + barracks
			+ "\nChurches: " + churches
			+ "\nMines: " + mines
			+ "\nWalls: " + walls;
	}

}
