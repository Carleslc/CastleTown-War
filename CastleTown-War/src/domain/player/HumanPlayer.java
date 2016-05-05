package domain.player;

public class HumanPlayer extends Player {

	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public void play() {
		// TODO
		damage(getLife()); // provisional to ensure that the program ends
	}

}
