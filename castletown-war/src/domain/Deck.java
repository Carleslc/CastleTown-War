package domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import domain.exceptions.DeckEmptyException;

/** Deck of cards */
public class Deck implements Iterable<Card> {

	public static final int MAX_LENGTH = 52; // FIXME cambiar tamaño al nuestro

	private static final Random rd = new Random();
	
	private LinkedList<Card> cards;
	
	/** Generate a deck of {@value #MAX_LENGTH} cards, shuffled or not */
	public Deck(boolean shuffle) {
		// TODO
	}
	
	/** Copy constructor */
	public Deck(Deck d) {
		cards = new LinkedList<Card>(d.cards);
	}
	
	/** @return the next card of the deck
	 *  @throws DeckEmptyException if deck is empty */
	public Card takeCard() throws DeckEmptyException {
		if (cards.size() == 0) throw new DeckEmptyException();
		return cards.pop();
	}
	
	/** @return number of cards remaining in the deck */
	public int remainingCards() {
		return cards.size();
	}
	
	/** Shuffles the deck randomly. */
	public void shuffle() {
		Collections.shuffle(cards, rd);
	}
	
	/** @return remaining cards on this deck */
	public String toString() {
		return cards.toString();
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
}
