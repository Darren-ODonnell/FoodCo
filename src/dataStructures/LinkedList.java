/**file name: LinkedList
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Allows user to make a LinkedList and allows access to methods for manipulating the data inside
 * */
package dataStructures;

//This class implements the ADT definition of a linked list using the same signatures. Note that we can add extra methods
//here once all of the methods listed in the ADT interface are included.

import application.Employee;

import javax.sound.sampled.Line;
import java.lang.reflect.InvocationTargetException;

public class LinkedList<T> implements LinkedListADT<T> {

    private int count;  // the current number of elements in the list
    private LinearNode<T> front; //pointer to the first element 
    private LinearNode<T> last; //pointer to the last element
    private LinearNode<T> current ;

    //-----------------------------------------------------------------
    //  Creates an empty list.
    //-----------------------------------------------------------------
    public LinkedList()
    {
        this.count = 0;
        this.last = new LinearNode<T>();
        this.front = new LinearNode<T>();
        this.current = new LinearNode<T>();
    }

    //  Adds one element to the end of this list
    public void add (T element) {
        LinearNode<T> node = new LinearNode<T> (element);

        if (count == 0) {
            front = node; // first node
        }
        else
            last.setNext(node); // add node to the end of the list

        last = node;
        current = last;

        count++;
    }

    //Adds an element to the list at the index provided
    public void add(T element, int index) {

        LinearNode<T> prev = new LinearNode<T>();
        LinearNode<T> next = new LinearNode<T>();
        LinearNode<T> newNode = new LinearNode<T>(element);

        if (count == 0) { // list empty add as first node
            last = newNode; // This is the last and the
            front = newNode; // first node
            current = newNode; // current node

        } else if (index == 1) { // add to head of list
            newNode.setNext(front);
            front = newNode;

        } else if (index >= count) { // index is equal to or greater than count - add to end of list
           last.setNext(newNode);
           last = last.getNext();
           current = last;

        } else {
            // move current to position newNode will be inserted
            int position = 1;
            current = front;

            while (index != position) {
                prev = current;
                current = current.getNext();
                position++;
            }
            prev.setNext(newNode);
            newNode.setNext(current);
            current = newNode;
        }
        count++;

    }

    //  Removes and returns the first element from this list
    public T remove() {
        T result = null;
        if (isEmpty()) {
            System.out.println("There are no nodes in the list");
        }//end if
        else {
            result = this.front.getElement();
            this.front = this.front.getNext();
            count--;
        }//end else
        return result;

    }

    //  Returns true if this list contains no elements
    public boolean isEmpty()
    {
         return  (this.front == null);
    }

    //  Returns the number of elements in this list
    public int size()
    {
        return this.count;
    }

    //  Returns a string representation of this list
    public String toString() {
        //LinearNode<T> current = this.front;
        String fullList = "";

        for (current = this.front; current != null; current = current.getNext())
        {
            fullList = fullList + "\n" + current.getElement().toString();
        }//end for

        return fullList + "\n";
    }

    // Checks if element is in list
    public boolean contains(T element) {
        boolean found = false;
        // start at head of list
        LinearNode<T> current = this.front;

        // string representation of object used to provide a comparison
        String elementStr = element.toString();

        while(current != null && !found){

            String curr = current.getElement().toString();

            found = curr.equals(elementStr);

            current = current.getNext();
        }
        return found;

    }

    // finds element passed as parameter and returns an index for the node
    public int getIndex(T element) {
        boolean found = false;
        int index = 0;
        // start at head of list
        LinearNode<T> current = this.front;

        // string representation of object used to provide a comparison
        String elementStr = element.toString();

        while(current != null && !found){

            String curr = current.getElement().toString();

            found = curr.equals(elementStr);

            current = current.getNext();

            index++;
        }
        return index;

    }

    // Returns element of next node in list
    public T getNext() {

        if (front != null) // implies non empty list
            if(current == null) { // implies no list traverse requested
                current = front;
            } else {
                current = current.getNext();
            }

        return current.getElement();

    }

    //Returns previous linear node in list, from current position
    private LinearNode<T> getPrevious(LinearNode<T> node) {
        LinearNode<T> previous;
        previous = front;

        while(previous.getNext() != node)
            previous = previous.getNext();

        return previous;

    }

    // Check if there is a next element in list to avoid null pointers
    public boolean hasNext() {
        return (current != last);
    }

    // returns element at index given
    public T get(int index) {
        LinearNode<T> node = front;
        int position = 1;

        if(index == count) // last element
            node = last;
        else // neither first or last
            while (position != index) {
                node = node.getNext();
                position++;
            }
        current = node;
        final T element = node.getElement();

        return element;
    }

    // Search for element passed as parameter and delete
    public void remove(T element){
        LinearNode<T> nodeToRemove;
        LinearNode<T> previous;
        int  position = getIndex(element);
        if(position == 1){
            //Element is at start of list
            front = front.getNext();
        }else if(position == count){
            //Element is at end of list
            previous = getPointerToNode(element);
            previous.setNext(null);
            last = previous;
        }else{
            previous = getPointerToNode(element);
            current = previous.getNext();
            previous.setNext(current.getNext());
        }
        count --;
//
    }

    // Remove element at position given
    public void remove(int position){
            LinearNode<T> previous;
            LinearNode<T> nodeToBeDeleted = getNodeAt(position);

            if (position == 1) {
                //Head of list
                if (count == 1) {
                    //One element in list
                    front = last = null;
                    count = 0;
                } else {
                    front = front.getNext();
                    count--;
                }
            } else if (position == count) {//Last element to be deleted
                previous = getPrevious(nodeToBeDeleted);
                last = previous;
                last.setNext(null);
                count--;

            } else {
                previous = getPrevious(nodeToBeDeleted);
                previous.setNext(nodeToBeDeleted.getNext());
                count--;
            }
        }

    // Returns linear node at position given
    private LinearNode<T> getNodeAt(int position) {
        LinearNode<T> node = front;
        if(position == 1){//Head of list
            node = front;
        }else if(position == count){//End of list
            node = last;
        }else{
            for(int i = 1; i < position; i++){
                node = node.getNext();
            }
        }
        return node;
    }

    // Used to get the node pointing to the current node for deletion
    private LinearNode<T> getPointerToNode(T element) {
        boolean same = false;
        LinearNode<T> curr = front;
        LinearNode<T> previous = new LinearNode<T>();

        if(curr ==  null)
            System.out.println("current is null");
        else {

            do {/**null pointer in here **/
                previous = curr;
                curr = curr.getNext();
            } while (curr != null && !curr.getElement().equals(element));
        }
        return previous;
    }

    // Returns fist element in list
    public T getFirst(){
        return this.front.getElement();

    }

    //Returns last element in list
    public T getLast(){
        return this.last.getElement();
    }

}
