package domain.player;

import java.util.ArrayList;

import domain.building.Barracks;
import domain.building.Church;
import domain.building.Mine;
import domain.building.Wall;

public class Town {
	
	private Player owner;
	private ArrayList<Barracks> barracks;
	private ArrayList<Church> churches;
	private ArrayList<Mine> mines;
	private ArrayList<Wall> walls;
	
	public Town(Player owner) {
		this.owner = owner;
		
		barracks = new ArrayList<>();
		barracks.add(new Barracks(owner));
		
		churches = new ArrayList<>();
		churches.add(new Church(owner));
		
		mines = new ArrayList<>();
		mines.add(new Mine(owner));
		
		walls = new ArrayList<>();
		walls.add(new Wall(owner));
	}

	public Player getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Barracks: " + barracks
			+ "\nChurches: " + churches
			+ "\nMines: " + mines
			+ "\nWalls: " + walls;
	}

}
