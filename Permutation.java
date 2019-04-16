/* *****************************************************************************
 *  Name:Sijo Xavier
 *  Date: 3-Feb-2019
 *  Description: Permutation
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {

        RandomizedQueue<String> que = new RandomizedQueue<String>();

        int k = Integer.parseInt(args[0]);

        // store the strings into randomized que
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            que.enqueue(s);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(que.dequeue());
        }

    }
}
