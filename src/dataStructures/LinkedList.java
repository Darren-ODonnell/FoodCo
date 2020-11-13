/**file name: LinkedList
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Allows user to make a LinkedList and allows access to methods for manipulating the data inside
 * */
package dataStructures;

//This class implements the ADT definition of a linked list using the same signatures. Note that we can add extra methods
//here once all of the methods listed in the ADT interface are included.

import application.Employee;

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
    public void add (T element)
    {
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
    public T remove()
    {
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

    public String toString()
    {
        //LinearNode<T> current = this.front;
        String fullList = "";

        for (current = this.front; current != null; current = current.getNext())
        {
            fullList = fullList + "\n" + current.getElement().toString();
        }//end for

        return fullList + "\n";
    }

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

    public T getNext() {

        if (front != null) // implies non empty list
            if(current == null) { // implies no list traverse requested
                current = front;
            } else {
                current = current.getNext();
            }

        return current.getElement();

    }

    public boolean hasNext() {
        return (current != last);
    }

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

    public void remove(T element){
        LinearNode<T> previous;

        switch(size()) {
            case 0:
                System.out.println("There are no nodes in the list");
                break;
            case 1:
                if (current.getElement().equals(element)) {
                    front = null;
                    last = null;
                } else
                    System.out.println("This element is not in list - no element removed");
                break;
            default:
                previous = getPointerToNode(element);

                // first element in list to be deleted
                if (previous == front) {
                    front = front.getNext();
                    current = front;
                } else  // last element in list to be deleted
                    if (previous.getNext() == last) {
                        previous.setNext(null);
                        last = previous;
                        current = previous;
                    } else { // not front or last

                        current = previous.getNext();
                        previous.setNext(current.getNext());
                        current = previous;

                    }
                }

                count--;
        }

        //Used to get the node pointing to the current node for deletion
    private LinearNode<T> getPointerToNode(T element) {
        boolean same = false;
        LinearNode<T> curr = front;
        LinearNode<T> previous = new LinearNode<T>();

        if(curr ==  null)
            System.out.println("current is null");
        else {

            do {
                previous = curr;
                curr = curr.getNext();
            } while (!curr.getElement().equals(element));
        }
        return previous;
    }

    public T getFirst(){
        return this.front.getElement();

    }
    public T getLast(){
        return this.last.getElement();
    }

}
