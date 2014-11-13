package util;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <h4>ADT Bag</h4>
 * <p>A <code>Bag</code> is an unordered collection of similar items (i.e., they are all of the same type).&nbsp;
 *   An item can be empty (<code>null</code>) and there is no restriction on the capacity of a bag.</p>
 * <p>The capabilities of a bag are:</p>
 * <ol>
 *   <li>Create an empty bag.</li>
 *   <li>Add an item to the bag.</li>
 *   <li>Add all the items from another bag.</li>
 *   <li>Determine if the bag is empty.</li>
 *   <li>Determine the number of items in the bag.</li>
 *   <li>Determine if an item is in the bag.</li>
 *   <li>Determine if the bag contains the same items as another bag.</li>
 *   <li>Remove a specific item from the bag.</li>
 *   <li>Remove a random item from the bag.</li>
 *   <li>Create a new bag that contains the items in two bags.</li>
 *   <li>Obtain an <code>Iterator</code> for the items in the bag.</li>
 * </ol>
 */
public interface Bag<T> {

  /**
   * Add an item to this bag.
   * @param item An item to be added.
   */
  public void add(T item);
  // Precondition: None.
  // Postcondition: The item is in the bag (i.e., this.contains(item) = true).
  // Throws: None.

  /**
   * Add the contents of another bag to this one.
   * @param other Another bag.
   */
  public void addAll(Bag<T> other);
  // Precondition: None.
  // Postcondition: All items from the other bag are now in this bag (i.e., for all item 'x' such that
  //                other.contains(x) is true then this.contains(x) is also true).
  // Throws: None.

  /**
   * Determine if this bag contains an item.
   * @param item An item to be checked.
   * @return <code>true</code> if this bag contains the specified item or <code>false</code> otherwise.
   */
  public boolean contains(T item);
  // Precondition: None.
  // Postcondition: If item is in this bag the result is true, otherwise the result is false.
  // Throws: None.

  /**
   * Determine if this bag is equivalent to another.
   * @param other Another bag.
   * @return <code>true</code> if the contents of this bag (in some order) and another bag are the same
   *         or <code>false</code> otherwise.
   */
  public boolean equals(Bag<T> other);
  // Precondition: None.
  // Postcondition: If the individual items in this bag and the other bag are identical the result is true,
  //                otherwise the result is false (note: the order of the items in the bags may be different).
  // Throws: None.

  /**
   * Determine if this bag is empty.
   * @return <code>true</code> if this bag contains no items or <code>false</code> if it contains at
   *         least one item.
   */
  public boolean isEmpty();
  // Precondition: None.
  // Postcondition: If this bag contains no items the result is true, otherwise if it contains one or more
  //                items the result is false.
  // Throws: None.

  /**
   * Obtain an iterator for this bag.
   * @return an iterator for the items in this bag.
   */
  public Iterator<T> iterator();
  // Precondition: None.
  // Postcondition: An object that implements the Iterator ADT for the contents of this bag is returned.
  // Throws: None.

  /**
   * Remove an item from this bag.
   * @param item The item to be removed.
   * @return The item that was removed.
   */
  public T remove(T item) throws NoSuchElementException;
  // Precondition: The item must be contained in this bag.
  // Postcondition: The item is removed and returned.
  // Throws: NoSuchElementException if the item is not contained in this bag.

  /**
   * Remove a random item from this bag.
   * @return The item that was removed.
   */
  public T removeRandom() throws BagException;
  // Precondition: This bag must contain at least one item (i.e., this.size() > 0).
  // Postcondition: An item, chosen at random, is removed and returned from this bag.
  // Throws: BagException if this bag is empty.

  /**
   * Determine the size of this bag.
   * @return The number of items in this bag.
   */
  public int size();
  // Precondition: None.
  // Postcondition: Returns the number of items that are in this bag.
  // Throws: None.

  /**
   * Perform a union of this bag with another bag.
   * @param other Another bag.
   * @return A new bag that is the union of both bags.
   */
  public Bag<T> union(Bag<T> other);
  // Precondition: None.
  // Postcondition: A new bag is created that contains all the items in this bag and the other bag.  If multiple
  //                copies of one item exist they are included in the bag that is created.
  // Throws: None.

  /**
   * Obtain a string representation for this bag.
   * @return A string representation for this bag (and its contents).
   */
  public String toString();
  // Precondition: None.
  // Postcondition: A string that represents this bag, and its contents, is returned.
  // Throws: None.
}