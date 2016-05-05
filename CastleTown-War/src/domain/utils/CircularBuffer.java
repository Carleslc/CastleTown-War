package domain.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * <b>Circular Queue</b> where elements are consecutive and you can iterate them without limit.
 * <p>For example: 5, 4, 3 can be iterated by this way: 5, 4, 3, 5, 4 ... while all elements are not removed.
 */
public class CircularBuffer<E> implements Queue<E> {
	
	private LinkedList<E> queue;
	
	/**
	 * Constructs an empty buffer.
	 */
	public CircularBuffer() {
		queue = new LinkedList<E>();
	}

	/**
	 * Constructs a list containing the elements of the specified collection,
	 * in the order they are returned by the collection's iterator.
	 * @param c the collection whose elements are to be placed into this list
	 * @throws NullPointerException if the specified collection is null
	 */
	public CircularBuffer(Collection<? extends E> c) {
		queue = new LinkedList<E>(c);
	}

	public boolean add(E e) {
		return queue.add(e);
	}

	private class CircularBufferIterator implements ListIterator<E> {
		
		private ListIterator<E> i;
		
		public CircularBufferIterator() {
			i = queue.listIterator();
		}
		
		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public E next() {
			if (!i.hasNext())
				i = queue.listIterator();
			return i.next();
		}

		@Override
		public boolean hasPrevious() {
			return !isEmpty();
		}

		@Override
		public E previous() {
			if (!i.hasPrevious() && !queue.isEmpty())
				i = queue.listIterator(queue.size());
			return i.previous();
		}

		@Override
		public int nextIndex() {
			if (!i.hasNext())
				i = queue.listIterator();
			return i.nextIndex();
		}

		@Override
		public int previousIndex() {
			if (!i.hasPrevious() && !queue.isEmpty())
				i = queue.listIterator(queue.size());
			return i.previousIndex();
		}

		@Override
		public void remove() {
			i.remove();
		}

		@Override
		public void set(E e) {
			i.set(e);
		}

		@Override
		public void add(E e) {
			i.add(e);
		}
		
	}

	@Override
	public String toString() {
		return queue.toString();
	}

	@Override
	public boolean contains(Object o) {
		return queue.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return listIterator();
	}
	
	public CircularBufferIterator listIterator() {
		return new CircularBufferIterator();
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return queue.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		return queue.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return queue.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return queue.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return queue.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return queue.removeAll(c);
	}

	@Override
	public boolean offer(E e) {
		return queue.offer(e);
	}

	@Override
	public E poll() {
		return queue.poll();
	}

	@Override
	public E element() {
		return queue.element();
	}

	@Override
	public E peek() {
		return queue.peek();
	}
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public E remove() {
		return queue.remove();
	}
	
	@Override
	public void clear() {
		queue.clear();
	}
	
}
