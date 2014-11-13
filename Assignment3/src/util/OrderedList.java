package util;

import java.util.Iterator;
import java.util.ConcurrentModificationException;

/**
 * <h4>ADT OrderedList</h4>
 * <p>An <code>OrderedList</code> is a finite ordered collection of similar items that are
 *   <code>Comparable</code>&#8211;the collection can only contain a specified number of items,
 *   they must all be the same type, and the items can be compared (i.e., the items implement the
 *   <code>Comparable</code> interface).&nbsp; Also, items cannot be <code>null</code>.  From a
 *   client's perspective, the items are numbered starting at one (1).</p>
 * <p>The capabilities of an ordered list are:</p>
 * <ol>
 *   <li>Create an empty ordered list.</li>
 *   <li>Create a list whose contents are the same as another ordered list.</li>
 *   <li>Add an item to the ordered list.</li>
 *   <li>Determine if the ordered list is empty or full.</li>
 *   <li>Remove an item from the ordered list.</li>
 *   <li>Remove all the items from the ordered list.</li>
 *   <li>Determine the current position in the ordered list.</li>
 *   <li>Change the current position in the ordered list.</li>
 *   <li>Determine the current size of the ordered list.</li>
 *   <li>Determine the maximum size of the ordered list.</li>
 *   <li>Retrieve an item from the ordered list.</li>
 *   <li>Sort the items in the ordered list.</li>
 * </ol>
 */
public interface OrderedList<T extends Comparable<T>> {

  /**
   * Obtain the item at the current position.
   *
   * @return The item stored at the current position in the list.
   * @throws OrderedListException If the list is empty.
   */
  public T getItem() throws OrderedListException;
  // Precondition: This list is not empty.
  // Postcondition: The item that corresponds to the current position number is returned.
  // Throws: OrderedListException if the list is empty.

  /**
   * Obtain the maximum size of the list.
   * 
   * @return The maximum number of items that can be stored in the list.
   */
  public int getMaximumSize();
  // Precondition: None.
  // Postcondition: The maximum number of items that can be stored in the list is returned.
  // Throws: None.

  /**
   * Obtain the current position for the list.&nbsp; The list's position indicator is
   * '1-based' <em>not</em> '0-based'.&nbsp; That is, the first position is numbered 1,
   * the second is numbered 2, etc.&nbsp; The last position is 'n' where 'n' is the number
   * of items in the list.
   * 
   * @return The current position.
   */
  public int getPosition();
  // Precondition: None.
  // Postcondition: The current position number is returned.
  // Throws: None.

  /**
   * Inserts an item into the list at the current position.&nbsp; If an element occupies
   * the current position before this call, that element will be the new item's
   * successor after the call.&nbsp; The list's current position does not change.&nbsp;
   * The first element in the list is defined to be at position 1 (one) <em>not</em> at
   * position zero (0).&nbsp; To insert an item after the last element in the list
   * (i.e., insert an item which will become the last one and will not have a successor)
   * you must use the <code>insertItem(T, int)</code> method.
   *
   * @see OrderedList insertItem(T, int)
   * @param item An item to be inserted.
   * @throws OrderedListException If the list is full.
   */
  public void insert(T item) throws OrderedListException;
  // Precondition: None.
  // Postcondition: An item is stored in the list such that (list.insert(item)).getItem() = item.
  // Postcondition: The logical position number of the original item stored at the current
  //                position (if any) and its successors are increased by one.
  // Throws: OrderedListException if the list is full.

  /**
   * Inserts an item into the list at a specified position.&nbsp; If the list is empty
   * or the position value is less than 1 (one), the item becomes the first one.&nbsp;
   * If position is greater than the current list size, the item becomes the last one.&nbsp;
   * If an element already occupies the specified position, that element will be the new
   * item's successor after the call.&nbsp; Before returning, the current position is
   * updated to item's position in the list.&nbsp; The current position will not be greater
   * than the current list size.
   *
   * @see OrderedList insertItem(T)
   * @param item An item to be inserted.
   * @param position The position in the list that the new item will occupy after insertion.
   * @throws OrderedListException If the list is full.
   */
  public void insert(T item, int position) throws OrderedListException;
  // Precondition: None.  If position < 1 then the call is treated as insert(item, 1) and if
  //               position > this.size() then the call is treated as insert(item, this.size() + 1).
  // Postcondition: An item is stored in the list at the specified position and the logical
  //                position number of the other items are adjusted accordingly.
  // Throws: OrderedListException if the list is full.

  /**
   * Determines if the list is empty.
   * 
   * @return <code>true</code> if the list is currently empty, <code>false</code> otherwise.
   */
  public boolean isEmpty();
  // Precondition: None.
  // Postcondition: Returns true if the list contains no items or false if it contains one or
  //                more items.
  // Throws: None.

  /**
   * Determines if the list is full.
   * 
   * @return <code>true</code> if the list is full, or <code>false</code> otherwise.
   */
  public boolean isFull();
  // Precondition: None.
  // Postcondition: Returns true if the list contains the maximum allowable number of items or
  //                false if it contains fewer than the maximum allowable number of items.
  // Throws: None.

  /**
   * Obtain an iterator for the elements in the list in their position number sequence.  If the list is
   * modified during execution of the iterator, the <code>next()</code> method of the iterator
   * will throw a <code>ConcurrentModificationException</code>.
   * 
   * @return An iterator for the elements of the list in their position number sequence.
   * @throws ConcurrentModificationException by the If the list is is modified during execution of the iterator.
   */
  public Iterator<T> iterator();
  // Precondition: None.
  // Postcondition: An object that implements the Iterator ADT for the contents of the list is returned.
  // Throws: None.

  /**
   * Increments the current position value for the list if the current position is not
   * already the last position; otherwise, the current position value is not changed.
   *
   * @throws OrderedListException If there is no next item or if the list is empty.
   */
  public void nextPosition() throws OrderedListException;
  // Precondition: None.
  // Postcondition: If the current position is < this.size() the current position is increased
  //                by 1, otherwise it is not changed.
  // Throws: OrderedListException if the list is empty or if current position = this.size().

  /**
   * Decrements the current position value for the list if the current position is not already at
   * the first position; otherwise, the current position value is not changed.
   *
   * @throws OrderedListException If there is no previous item or if the list is empty.
   */
  public void previousPosition() throws OrderedListException;
  // Precondition: None.
  // Postcondition: If the current position is > 1 the current position is decreased by 1,
  //                otherwise it is not changed.
  // Throws: OrderedListException if the current position = 1.

  /**
   * The item at the current position is removed from the list.&nbsp; If the removed
   * item had a successor then that successor will be at the current position after the
   * removal.&nbsp; The current position is not changed unless the list becomes empty (in
   * that case the current position is set to 1 (one)) or the last item in the list is
   * removed (in that case the current position is set to the current number of items in the
   * list after the removal).
   *
   * @see #removeAll()
   * @see #remove(int)
   * @throws OrderedListException If the list is empty.
   */
  public void remove() throws OrderedListException;
  // Precondition: An item must exist at the current position.
  // Postcondition: The item at the current position is removed and the logical
  //                position number of the other items are adjusted accordingly.
  // Postcondition: If the list becomes empty, the current position is set to 1; if the last
  //                item is removed (and the list is not empty after the removal) the current
  //                position is set to this.size(); otherwise, the current position is not changed.
  // Throws: OrderedListException if the list is empty.

  /**
   * The item at the specified position is removed from the list.&nbsp; If the removed item
   * had a successor then that successor will be at the vacated position after the removal.&nbsp;
   * The current position is not changed unless the current position exceeds the length of the list
   * after the removal (in that case the current position is set to the size of the list (or 1 (one)
   * if the list is empty).
   *
   * @param position The position of the item to be removed.
   * @see #removeAll()
   * @see #remove()
   * @throws OrderedListException If the list is empty or the position number is illegal.
   */
  public void remove(int position) throws OrderedListException;
  // Precondition: An item must exist at the provided position number.
  // Postcondition: The item at the provided position is removed and the logical
  //                position number of the other items are adjusted accordingly.
  // Postcondition: If the current position exceeds the size of the list (after the removal), the
  //                current position is set to 1 if the list became empty or this.size() if this
  //                list did not become empty, otherwise the current position is not changed.
  // Throws: OrderedListException if the list is empty.

  /**
   * The list is made empty.
   * 
   * @see #remove()
   * @see #remove(int position)
   */
  public void removeAll();
  // Precondition: None.
  // Postcondition: All items are removed from the list.
  // Postcondition: The current position is set to 1.
  // Throws: None.

  /**
   * Sets the current position value for the list.&nbsp; The position value must be
   * between 1 (one) and the number of items in the list.&nbsp; If the provided
   * value is less than one (1), the position value will be set to one (1).&nbsp; If
   * the provided value is greater than the number of items in the list, the position
   * value will be set to the number of items in the list (or 1 (one) if the list is empty).
   *
   * @param position The value for the list's current position.
   */
  public void setPosition(int position);
  // Precondition: None.  If position < 1 then the call is treated as setPosition(1) and if
  //               position > this.size() then the call is treated as setPosition(max(1, this.size())).
  // Postcondition: The current position is set to the provided position.
  // Throws: None.

  /**
   * Obtain the size of the list.
   * 
   * @return The current number of elements in the list.
   */
  public int size();
  // Precondition: None.
  // Postcondition: The number of items currently stored in the list is returned.
  // Throws: None.

  /**
   * Sorts the list into ascending order according to the natural ordering of the items.&nbsp;
   * The natural ordering can be determined by the <code>compareTo()</code> method.&nbsp; Before
   * returning to the caller, the current position will be set at the last (end of list) position.
   */
  public void sort();
  // Precondition: None.
  // Postcondition: The items in the list are re-arranged such that their logical position number
  //                reflects their natural order (ascending).
  // Postcondition: The current position number is set to max(1, this.size()).
  // Throws: None.
}