package util;

public class SimpleList<T extends Comparable<T>> implements OrderedList<T> {
	
	private final int DEFAULT_CAPACITY = 10;
	
	private SimpleListNode<T> head;
	private int currentPosition;
	private int maximumSize;
	
	public SimpleList() {
		this.maximumSize = DEFAULT_CAPACITY;
		currentPosition = 1;
	}
	
	public SimpleList(int maximumSize) {
		this.maximumSize = maximumSize;
		currentPosition = 1;
	}
	
	public SimpleList(SimpleList<T> other) {
		
	}

	@Override
	public T getItem() throws OrderedListException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMaximumSize() {
		return maximumSize;
	}

	public int getPosition() {
		return currentPosition;
	}

	@Override
	public void insert(T item) throws OrderedListException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(T item, int position) throws OrderedListException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void nextPosition() throws OrderedListException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousPosition() throws OrderedListException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() throws OrderedListException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int position) throws OrderedListException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	
	public class SimpleListNode<E> {
		
		E data;
		SimpleListNode<E> next;
		
		public SimpleListNode(E data, SimpleListNode<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public SimpleListNode(E data) {
			this(data, null);
		}
	}
}
