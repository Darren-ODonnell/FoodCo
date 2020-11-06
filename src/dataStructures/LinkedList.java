/**file name: LinkedList
 * Author: Darren O'Donnell
 * Student number: C19313413
 * Description of class: Allows user to make a LinkedList and allows access to methods for manipulating the data inside
 * */
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

        if (count == 0)
            this.front = node; // first node
        else
            last.setNext(node); // add node to the end of the list

        last = node;
        count++;
    }

    //Adds an element to the list at the index provided
    public void add(T element, int index){

        LinearNode<T> prev = new LinearNode<T> ();
        LinearNode<T> next = new LinearNode<T> ();
        LinearNode<T> newNode = new LinearNode<T> (element);

/** Needed above where this add is called, instead of in here
        //if(index > count){
            //Error
            //get a new number
            }
            if(index == count){
                add(emp);
            }

 **/
        if (size() == 0) {
            this.last = newNode; // This is the last and the
            this.front = newNode; // first node
            this.current = newNode; // current node
            this.count++;
        }
        // move current to position newnode will be inserted
        int position = 1;
        current = front;
        while(index != position) {
            prev = current;
            current=current.getNext();
            position++;
        }
        prev.setNext(newNode);
        newNode.setNext(current);
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

    public T get(int index) {
        LinearNode<T> node = front;
        int position = 1;

        if(index == size())
            node = last;
        else
            while (position != index) {
                node = node.getNext();
                position++;
            }

        return node.getElement();
    }
}
