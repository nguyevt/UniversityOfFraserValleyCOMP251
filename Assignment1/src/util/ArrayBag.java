package util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArrayBag<E> implements Bag<E> {

	private final int DEFAULT_CAPACITY = 10;
	private E[] bag;
	private int size;
	
	public ArrayBag() {
		this.bag = (E[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}
	
	public ArrayBag(int capacity) {
		this.bag = (E[]) new Object[capacity];
		this.size = 0;
	}
	
	public void add(E item) {
		if (size() == bag.length) {
			E[] temp = (E[]) new Object[size * 2];
			for (int i = 0; i < bag.length; i++) {
				temp[i] = bag[i];
			}
			bag = temp;
		}
		bag[size] = item;
		size++;
	}

	public void addAll(Bag<E> other) {
		Iterator<E> iterator = other.iterator();
		while (iterator.hasNext()) {
			add(iterator.next());
		}
	}

	public boolean contains(E item) {
		Iterator<E> iterator = this.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(item)) {
				return true;
			}
		}
		return false;
	}

	public boolean equals(Bag<E> other) {
		if (other.size() != this.size()) {
			return false;
		}
		Iterator<E> otherIterator = other.iterator();
		Iterator<E> thisIterator = iterator();
		while (thisIterator.hasNext()) {
			if (!other.contains(thisIterator.next())) {
				return false;
			}
		}
		while (otherIterator.hasNext()) {
			if (!this.contains(otherIterator.next())) {
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<E> iterator() {
		return new BagIterator<E>(this.bag, this.size);
	}

	public E remove(E item) throws NoSuchElementException {
		for (int i = 0; i < size(); i++) {
			if (bag[i].equals(item)) {
				E value = bag[i];
				bag[i] = bag[size() - 1];
				size--;
				return value;
			}
		}
		throw new NoSuchElementException();
	}

	public E removeRandom() throws BagException {
		if (isEmpty()) {
			throw new BagException();
		} else {
			Random random = new Random();
			int index = random.nextInt(size());
			E value = bag[index];
			bag[index] = bag[size() - 1];
			size--;
			return value;
		}
	}

	public int size() {
		return this.size;
	}

	public Bag<E> union(Bag<E> other) {
		Bag<E> bag = new ArrayBag();
		bag.addAll(other);
		Iterator<E> iterator = this.iterator();
		while (iterator.hasNext()) {
			bag.add(iterator.next());
		}
		return bag;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		String prefix = " ";
		for (Iterator<E> it = this.iterator(); it.hasNext();) {
			sb.append(prefix).append(it.next());
			prefix = ", ";
		}
		return sb.append(' ').append('}').toString();
	}

	private class BagIterator<E> implements Iterator<E> {
		
		E[] bag;
		int size;
		int current;
		
		public BagIterator(E[] bag, int size) {
			this.bag = bag;
			this.size = size;
			this.current = 0;
		}

		public boolean hasNext() {
			return current < size;
		}

		public E next() {
			if (hasNext()) {
				current++;
				return bag[current - 1];
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
