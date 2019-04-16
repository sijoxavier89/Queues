/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Testque {
    Deque<Integer> deque;

    public Testque() {
        deque = new Deque<Integer>();
    }

    public void testDequeAddRemove() {
        StdOut.println("input:testing add first and remove last");
        int num = 10;
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

    }

    public void testDequeSize() {
        StdOut.println("testDequeSize");
        StdOut.println("input size:10");
        int num = 10;
        deque = new Deque<Integer>();
        // add items
        for (int i = 0; i < num; i++) {
            StdOut.println(i);
            deque.addFirst(i);
        }

        StdOut.println("output size");
        StdOut.println(deque.size());
    }

    public void testDequeIterator() {
        StdOut.println("input:testing iterator");
        int num = 10;
        // add items
        for (int i = 0; i < num; i++) {
            StdOut.println(i);
            deque.addFirst(i);
        }
        // print items added in ascending order
        StdOut.println("Output : Iterator");
        for (int s : deque)
            StdOut.println(s);

    }

    public void testEmptyAddFirstThenRemoveLast() {
        StdOut.println("testEmpty AddFirst Then RemoveLast");
        deque = new Deque<Integer>();
        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

        deque.addFirst(1);
        int item = deque.removeLast();
        StdOut.println("Removed item");
        StdOut.println(item);

        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

    }

    public void testEmptyAddLastThenRemoveFirst() {
        StdOut.println("test Empty AddLast Then Remove First");
        deque = new Deque<Integer>();
        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

        deque.addLast(1);
        int item = deque.removeFirst();
        StdOut.println("Removed item");
        StdOut.println(item);

        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

    }

    public void testEmptyAddFirstThenRemoveFirst() {

        StdOut.println("test Empty AddFirst Then RemoveFirst");
        deque = new Deque<Integer>();
        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

        deque.addFirst(1);
        int item = deque.removeFirst();
        StdOut.println("Removed item");
        StdOut.println(item);

        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

    }

    public void testEmptyAddLastThenRemoveLast() {

        StdOut.println("test Empty AddLast Then Remove Last");
        deque = new Deque<Integer>();
        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

        deque.addLast(1);
        int item = deque.removeLast();
        StdOut.println("Removed item");
        StdOut.println(item);

        StdOut.println("Is empty");
        if (deque.isEmpty())
            StdOut.println("Yes");
        else
            StdOut.println("No");

    }


    public void testRandomQueIterator() {
        int n = 10;
        RandomizedQueue<Integer> rque = new RandomizedQueue<Integer>();

        for (int i = 0; i < n; i++) {
            rque.enqueue(i);
        }

        for (int s : rque) {
            StdOut.println(s);
        }

    }

    public void testRandomQueEmpty() {
        StdOut.println("testRandomQueEmpty");
        RandomizedQueue<Integer> rque = new RandomizedQueue<Integer>();
        if (rque.isEmpty()) {
            StdOut.println("Empty");
        }
    }


    public void testRandomQueSize() {
        StdOut.println("testRandomQueSize");

        int n = 10;
        RandomizedQueue<Integer> rque = new RandomizedQueue<Integer>();

        for (int i = 0; i < n; i++) {
            rque.enqueue(i);
        }

        StdOut.println("Expected output - 10");
        StdOut.println(rque.size());

    }

    public void testRandomQueSample() {
        StdOut.println("testRandomQueSample");

        int n = 10;
        RandomizedQueue<Integer> rque = new RandomizedQueue<Integer>();

        for (int i = 0; i < n; i++) {
            rque.enqueue(i);
        }

        StdOut.println(rque.sample());
        StdOut.println(rque.sample());
        StdOut.println(rque.sample());
        StdOut.println(rque.sample());


    }

    public void testFailed1() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(1);
        rq.enqueue(7);
        rq.enqueue(28);
        rq.dequeue();
        StdOut.println(rq.size());

    }

    public void testRandomDeque() {
        StdOut.println("testRandomQueSample");

        int n = 500;
        RandomizedQueue<Integer> rque = new RandomizedQueue<Integer>();

        for (int i = 0; i < n; i++) {
            rque.enqueue(i);
        }

        StdOut.println("Dequeue output after 500 calls");

        for (int i = 0; i < n; i++) {
            StdOut.println(rque.dequeue());
        }

    }

    public void testRandomSample() {
        StdOut.println("testRandomQueSample");

        int n = 500;
        RandomizedQueue<Integer> rque = new RandomizedQueue<Integer>();

        for (int i = 0; i < n; i++) {
            rque.enqueue(i);
        }

        StdOut.println("Dequeue output after 500 calls");

        for (int i = 0; i < n; i++) {
            StdOut.println(rque.sample());
        }

    }

    public void testFailedDequeSize() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        StdOut.println(1);
        StdOut.println("remove last added");
        StdOut.println(deque.removeFirst());
        StdOut.println("Is empty");
        StdOut.println(deque.isEmpty());
        StdOut.println("Is empty");
        StdOut.println(deque.isEmpty());
        StdOut.println("Size:");
        StdOut.println(deque.size());

        StdOut.println("Is empty");
        StdOut.println(deque.isEmpty());
        StdOut.println("Is empty");
        deque.addLast(7);
        StdOut.println(7);
        deque.removeLast();
        StdOut.println("remove last added");
        StdOut.println("Is empty");
        StdOut.println(deque.isEmpty());
        StdOut.println("Size:");
        StdOut.println(deque.size());
    }

    public void test5Deque() {
        Deque<Integer> deque = new Deque<Integer>();
        StdOut.println(deque.isEmpty());
        deque.addLast(2);
        StdOut.println("remove last added:2");
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        deque.addLast(4);
        StdOut.println("remove last added:4");
        StdOut.println(deque.removeLast());
    }

    public static void main(String[] args) {

        Testque testque = new Testque();
        /* StdOut.println("Testing Deque");
        testque.testDequeAddRemove();
        testque.testDequeIterator();
        testque.testDequeSize();
        testque.testEmptyAddFirstThenRemoveFirst();
        testque.testEmptyAddFirstThenRemoveLast();
        testque.testEmptyAddLastThenRemoveFirst();
        testque.testEmptyAddLastThenRemoveLast();*/
        // testque.testFailedDequeSize();
        testque.test5Deque();

        StdOut.println("Testing randomized Deque");
        // testque.testRandomQueIterator();
        // testque.testRandomQueEmpty();
        // testque.testRandomQueSample();
        // testque.testRandomQueSize();
        // testque.testFailed1();
        // testque.testRandomDeque();

    }
}
