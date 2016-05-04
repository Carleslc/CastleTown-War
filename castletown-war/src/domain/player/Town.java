package domain.player;

import java.util.ArrayList;

import domain.Player;
import domain.player.building.Barracks;
import domain.player.building.Church;
import domain.player.building.Mine;
import domain.player.building.Wall;

public class Town {
	Player owner;
	ArrayList<Barracks> barracks;
	ArrayList<Church> churches;
	ArrayList<Mine> mines;
	ArrayList<Wall> walls;
	public Town(Player owner){
		this.owner = owner;
		
		barracks = new ArrayList<Barracks>();
		barracks.add(new Barracks(owner));
		
		churches = new ArrayList<Church>();
		churches.add(new Church(owner));
		
		mines = new ArrayList<Mine>();
		mines.add(new Mine(owner));
		
		walls = new ArrayList<Wall>();
		walls.add(new Wall(owner));
	}
}
