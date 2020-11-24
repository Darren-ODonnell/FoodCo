//Abstract Data Type definition for a Linked List

//Note that this is not a full definition as we are only implementing some
//of the standard functions associated with a list.

package dataStructures;

public interface LinkedListADT <T>
	{
		//  Adds one element to the start or end of this list
		public void add (T element);

		//  Removes and returns the first element from this list
		public T remove();

		//  Returns true if this list contains no elements
		public boolean isEmpty();

		//  Returns the number of elements in this list
		public int size();

		//  Returns a string representation of this list
		public String toString();

		// search if element already exists in list
		public boolean contains(T element);

		// finds element passed as parameter and returns an index for the node
		public int getIndex(T element);

		// Returns element of next node in list
		public T getNext();

		// Check if there is a next element in list to avoid null pointers
		public boolean hasNext();

		// returns element at index given
		public T get(int index);

		// Search for element passed as parameter and delete
		public void remove(T element);

		// Remove element at position given
		public void remove(int position);

		// Returns fist element in list
		public T getFirst();

		//Returns last element in list
		public T getLast();
}

