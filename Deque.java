/* *****************************************************************************
 *  Name: Sijo Xavier
 *  Date: 02 Feb 2019
 *  Description: Deque data structure
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node first = null;
    private Node last = null;

    private class Node {

        Item item;
        Node next;
    }

    public Deque()                           // construct an empty deque
    {

    }

    public boolean isEmpty()                 // is the deque empty?
    {
        return first == null;
    }

    public int size()                        // return the number of items on the deque
    {
        return size;
    }

    public void addFirst(Item item)          // add the item to the front
    {
        validate(item);
        // if this is the first node
        if (first == null) {
            first = new Node();
            first.item = item;
            first.next = null;

            // first node equal to last node when there is only one node
            last = first;
        }
        else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }

        size++;
    }

    public void addLast(Item item)           // add the item to the end
    {
        validate(item);
        // if this is the first node
        if (first == null) {
            first = new Node();
            first.item = item;
            first.next = null;

            // first node equal to last node when there is only one node
            last = first;
        }
        else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            oldLast.next = last;
        }

        size++;
    }

    private void validate(Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public Item removeFirst()                // remove and return the item from the front
    {
        validateDeque();

        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item removeLast()                 // remove and return the item from the end
    {
        validateDeque();

        Item lastItem = last.item;
        last = null;

        if (size == 1) {
            first = null;
            size--;
            return lastItem;
        }


        // set the second last item to new last item
        Node current = first;

        while (current.next.next != null) {
            current = current.next;
        }
        last = current;
        last.next = null;
        size--;
        return lastItem;

    }

    private void validateDeque() {
        if (first == null) {
            throw new java.util.NoSuchElementException();
        }
    }

    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;

            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static void main(String[] args)   // unit testing (optional)
    {
        StdOut.println("input:testing add first and remove last");
        int num = Integer.parseInt(args[0]);

        Deque<Integer> deque = new Deque<Integer>();
        // add items
        for (int i = 0; i < num; i++) {
            StdOut.println(i);
            deque.addFirst(i);
        }
        // print items added in ascending order
        StdOut.println("Output:testing add first and remove last");
        for (int i = 0; i < num; i++) {
            int item = deque.removeLast();
            StdOut.println(item);
        }

        StdOut.println("Test empty deque");

        int size = deque.size();
        StdOut.println(size);

        // StdOut.println("Output:call removeLast() with empty deque");
        // deque.removeLast();

        // StdOut.println("Output:call removeFirst() with empty deque");
        // deque.removeFirst();
    }
}

