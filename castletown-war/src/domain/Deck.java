package domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import domain.cards.Card;
import domain.exceptions.DeckEmptyException;

/**
 * Deck of cards
 */
public class Deck implements Iterable<Card> {

	public static final int MAX_LENGTH = 52; // FIXME

	private static final Random rd = new Random();
	
	private LinkedList<Card> cards;
	
	/**
	 * Generate a deck of {@value #MAX_LENGTH} cards, shuffled or not
	 */
	public Deck(boolean shuffle) {
		// TODO
	}
	
	/**
	 * Generate a shuffled deck of {@value #MAX_LENGTH} cards
	 */
	public Deck() {
		this(true);
	}
	
	/**
	 * Copy constructor
	 */
	public Deck(Deck d) {
		cards = new LinkedList<Card>(d.cards);
	}
	
	/**
	 * Take a card of the top of this deck
	 * @return the next card of this deck
	 * @throws DeckEmptyException if this deck is empty
	 */
	public Card takeCard() throws DeckEmptyException {
		if (cards.size() == 0) throw new DeckEmptyException();
		return cards.pop();
	}
	
	/**
	 * Get the number of remaining cards in this deck
	 * @return number of remaining cards in this deck
	 */
	public int remainingCards() {
		return cards.size();
	}
	
	/**
	 * Shuffles this deck randomly
	 */
	public void shuffle() {
		Collections.shuffle(cards, rd);
	}
	
	public String toString() {
		return cards.toString();
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
}
