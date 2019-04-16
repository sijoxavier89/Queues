/* *****************************************************************************
 *  Name:Sijo Xavier
 *  Date: 3-Feb-2019
 *  Description: RandamizedQue
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private int arraySize;
    private Item[] randomQue = null;

    public RandomizedQueue()                 // construct an empty randomized queue
    {
        randomQue = (Item[]) new Object[1];
        arraySize = randomQue.length;
        size = 0;
    }

    public boolean isEmpty()                 // is the randomized queue empty?
    {
        return size == 0;
    }

    public int size()                        // return the number of items on the randomized queue
    {
        return size;
    }

    public void enqueue(Item item)           // add the item
    {
        if (item == null) {
            throw new java.lang.IllegalArgumentException();
        }

        arraySize = randomQue.length;
        if (size == arraySize) {
            resizeQue(2 * size);
        }
        randomQue[size++] = item;
    }

    public Item dequeue()                    // remove and return a random item
    {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }
        arraySize = randomQue.length;
        Item item = null;
        int index = 0;
        while (item == null) {
            index = StdRandom.uniform(arraySize);
            item = randomQue[index];
        }
        randomQue[index] = null;
        size--;
        if (size > 0 && size == arraySize / 4) {
            resizeQue(2 * size);
        }
        return item;
    }

    public Item sample()                     // return a random item (but do not remove it)
    {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }

        Item item = null;
        int index = 0;
        while (item == null) {
            index = StdRandom.uniform(arraySize);
            item = randomQue[index];
        }
        return randomQue[index];
    }

    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomQueIterator();
    }

    private void resizeQue(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        int j = 0;
        for (int i = 0; i < arraySize; i++) {
            if (randomQue[i] != null) {
                copy[j] = randomQue[i];
                j++;
            }
        }

        randomQue = copy;
        arraySize = randomQue.length; // reset the array size variable
    }

    private class RandomQueIterator implements Iterator<Item> {

        private int index;

        public boolean hasNext() {
            return size > 0;
        }

        public Item next() {

            if (size == 0) {
                throw new java.util.NoSuchElementException();
            }
            index = StdRandom.uniform(arraySize);
            Item item = randomQue[index];
            return item;
        }


        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

}
