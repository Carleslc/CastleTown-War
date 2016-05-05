package domain.player;

public class AIPlayer extends Player {

	public AIPlayer(String name) {
		super(name);
	}

	@Override
	public void play() {
		// TODO
		damage(getLife()); // provisional to ensure that the program ends
	}

}
