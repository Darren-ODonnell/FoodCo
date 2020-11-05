package dataStructures;

//This class implements the ADT definition of a linked list using the same signatures. Note that we can add extra methods
//here once all of the methods listed in the ADT interface are included.

import application.Employee;

public class LinkedList<T> implements LinkedListADT<T> {

    private int count;  // the current number of elements in the list
    private LinearNode<T> front; //pointer to the first element 
    private LinearNode<T> last; //pointer to the last element
    private LinearNode<T> current;
    //-----------------------------------------------------------------
    //  Creates an empty list.
    //-----------------------------------------------------------------
    public LinkedList()
    {
        this.count = 0;
        this.last = null;
        this.front = null;
        this.current = null;
    }

    //  Adds one element to the end of this list
    public void add (T element)
    {
        LinearNode<T> node = new LinearNode<T> (element);

        if (size() == 0) {
            this.last = node; // This is the last and the
            this.front = node; // first node
            this.count++;
        }//end if
        else
        {
            last.setNext(node); // add node to the end of the list
            last = node; // now make this the new last node.
            count++;
        } //end if
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
        LinearNode current = this.front;

        // while getnext() is not null check list contents

        while(current.getNext() != null && found == false) {
            current = current.getNext();
            if (current.getElement() == element)
                found = true;
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
}
