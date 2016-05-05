package domain;

import java.util.Collection;
import java.util.ListIterator;

import domain.player.AIPlayer;
import domain.player.HumanPlayer;
import domain.player.Player;
import domain.utils.CircularBuffer;
import domain.utils.IO;

public class Game implements Runnable {

	private CircularBuffer<Player> players;
	private boolean isGameOver;

	/**
	 * Initialize a Game asking for players through console.
	 */
	public Game() {
		initPlayers();
	}
	
	/**
	 * Initialize a Game with the specified players.
	 * @param players players to play this game
	 * @throws IllegalArgumentException if <code>players.size() < 2</code>
	 */
	public Game(Collection<Player> players) throws IllegalArgumentException {
		if (players.size() < 2)
			throw new IllegalArgumentException("A game must have at least two players!");
		this.players = new CircularBuffer<>(players);
	}
	
	/**
	 * Plays this game.
	 */
	public void run() {
		isGameOver = false;
		int roundNumber = 1;
		System.out.println("Let the game begin!");
		
		while (!isGameOver) {
			System.out.println("Round " + roundNumber);
			nextRound();
			roundNumber++;
		}
		
		System.out.println("Game finished! Winner is " + players.peek().getName());
	}
	
	/**
	 * Start a new round.
	 */
	private void nextRound() {
		int turnNumber = 1;
		ListIterator<Player> it = players.listIterator();
		// Inv: players contains all players alive
		while (!isGameOver && it.nextIndex() < players.size()) {
			System.out.println("Turn " + turnNumber);
			nextTurn(it);
			turnNumber++;
		}
	}
	
	/**
	 * Start a new turn.
	 * @param it iterator pointing to a valid next player.
	 */
	private void nextTurn(ListIterator<Player> it) {
		Player player = it.next();
		System.out.println("Playing " + player.getName());
		player.play();
		checkGameOver(it);
	}

	/**
	 * Iterates all players checking deaths and updating the players queue.
	 * Sets {@link #isGameOver} to <code>true</code> when only one player is living.
	 * @param it iterator which previous is the last player that has played
	 */
	private void checkGameOver(ListIterator<Player> it) {
		int currentPosition = it.previousIndex();
		
		// Check if current player died this turn
		boolean currentPlayerIsDead = !it.previous().isAlive();
		it.next();
		
		// Check other dead players
		while (it.nextIndex() != currentPosition) {
			if (!it.next().isAlive())
				it.remove();
		}
		
		it.next(); // Same point as initially

		if (currentPlayerIsDead)
			it.remove();
		
		isGameOver = players.size() == 1;
	}
	
	private void initPlayers() {
		players = new CircularBuffer<>();
		
		int nOfPlayers = 0;
		int nOfHumanPlayers = 0;
		
		System.out.println("How many players will this game have?");
		nOfPlayers = IO.nextIntMinimum(2);
		
		do {
			System.out.println("How many of those are going to be human?");
			nOfHumanPlayers = IO.nextIntMinimum(0);
			if (nOfPlayers < nOfHumanPlayers)
				System.out.println("The number of players can't be less than the number of HUMAN players!");
		} while (nOfPlayers < nOfHumanPlayers);
		
		for (int i = 1; i <= nOfHumanPlayers; ++i)
			players.add(new HumanPlayer(String.valueOf(i)));
		
		for (int i = 1; i <= nOfPlayers - nOfHumanPlayers; ++i)
			players.add(new AIPlayer("AI-" + i));
	}

	@Override
	public String toString() {
		return "Players Alive: " + players;
	}
	
}
