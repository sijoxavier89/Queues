/* *****************************************************************************
 *  Name: Sijo Xavier
 *  Date: 17-Jan-2019
 *  Description: This class provides apis for testing Perlocation class
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double PERC95 = 1.96;

    private final double[] fractionsOpen;
    private final int trialNum;
    private double mean;
    private double std;

    /**
     * perform trials independent experiments on an n-by-n grid
     *
     * @param n      integer representing the size of n-by-n grid
     * @param trials integer representing the number of trials
     */
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        double size = (double) (n * n);
        trialNum = trials;
        fractionsOpen = new double[trials];

        while (trials != 0) {

            int row;
            int col;

            Percolation perc = new Percolation(n);

            while (!perc.percolates()) {
                row = StdRandom.uniform(1, n + 1);
                col = StdRandom.uniform(1, n + 1);

                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                }
            }

            double openSites = (double) perc.numberOfOpenSites();
            final double fractionOpen = openSites / size;

            fractionsOpen[trials - 1] = fractionOpen;
            trials--;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        mean = StdStats.mean(fractionsOpen);
        return mean;

    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        std = StdStats.stddev(fractionsOpen);
        return std;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - ((PERC95 * std) / Math.sqrt(trialNum));

    }

    public double confidenceHi() {
        return mean + ((PERC95 * std) / Math.sqrt(trialNum));


    }

    /**
     * Reads two inputs n and trials sequentially open sites till it perlocates displays mean and
     * standard deviation of perlocation threshold
     *
     * @param args commandline inputs
     */
    public static void main(String[] args) {

        int size = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);

        PercolationStats perc = new PercolationStats(size, trial);

        double mean = perc.mean();
        double stdv = perc.stddev();
        double coLo = perc.confidenceLo();
        double coHi = perc.confidenceHi();

        String sConfidenceHi = String.format("%f", coHi);
        String sConfidenceLo = String.format("%f", coLo);

        StdOut.println(String.format("mean:                           %f", mean));
        StdOut.println(String.format("stddev:                         %f", stdv));
        StdOut.println(
                "95% confidence interval:        [" + sConfidenceHi + " , " + sConfidenceLo + "]");


    }
}
