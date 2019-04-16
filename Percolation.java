/* *****************************************************************************
 *  Name:Sijo Xavier
 *  Date:
 *  Description:Perlocation
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final boolean OPEN = true;
    private static final boolean CLOSED = false;
    private static final int IDVIRTUALTOP = 0;
    private boolean[][] grid;
    private final int sizeOfTheSite;
    private final WeightedQuickUnionUF ufHelper;
    private final int totalSites;
    private int totalOpenSites;


    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        sizeOfTheSite = n;
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = CLOSED;
            }
        }
        totalSites = sizeOfTheSite * sizeOfTheSite;

        // 2 additional sites added to total sites for virtual top and virtual bottom sites
        ufHelper = new WeightedQuickUnionUF(totalSites + 2);
    }

    /**
     * Open the site and connect to adjacent open sites
     *
     * @param row the integer representing row number
     * @param col the integer representing column number
     */
    public void open(int row, int col) {
        validateSite(row, col);
        int i = row - 1;
        int j = col - 1;

        grid[i][j] = OPEN;
        totalOpenSites++;
        // if the row is the top most row,connect to virtual top (full site)
        if (i == 0) {
            ufHelper.union(IDVIRTUALTOP, xyToId(row, col));
        }

        // if last row , connect to virtual bottom
        if (i == sizeOfTheSite - 1) {
            ufHelper.union(totalSites + 1, xyToId(row, col));
        }

        // connect to adjacent open sites
        connectToAdjacentSites(row, col);
    }

    public boolean isOpen(int row, int col) {
        validateSite(row, col);

        return grid[row - 1][col - 1] == OPEN;
    }

    public boolean isFull(int row, int col) {
        validateSite(row, col);
        return ufHelper.connected(IDVIRTUALTOP, xyToId(row, col));

    }

    // return the number of sites in the connected component
    public int numberOfOpenSites() {
        return totalOpenSites;
    }

    // return true if the system perlocates
    public boolean percolates() {
        return ufHelper.connected(0, totalSites + 1);
    }

    private int xyToId(int row, int col) {
        int id = ((row - 1) * sizeOfTheSite) + col;
        return id;
    }

    /**
     * Validate the indexes of the site throws IllegalArgumentException for invalid indexes
     *
     * @param row integer representing row index of the site
     * @param col integer representing column index of the site
     */
    private void validateSite(int row, int col) {
        if (row < 1 || row > sizeOfTheSite || col < 1 || col > sizeOfTheSite) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Connect the open site to nearby open site
     *
     * @param row the integer representing row number
     * @param col the integer representing column number
     */
    private void connectToAdjacentSites(int row, int col) {

        int idOpenSite = xyToId(row, col);
        int i = row - 1;
        int j = col - 1;
        int firstRow = IDVIRTUALTOP + 1;
        int firstCol = IDVIRTUALTOP + 1;
        // connect to open right site
        if (!((col == sizeOfTheSite) || (row == sizeOfTheSite) || (row == 1))) {
            if (grid[i][j + 1] == OPEN) {
                int idRight = xyToId(row, col + 1);
                if (!ufHelper.connected(idOpenSite, idRight)) {
                    ufHelper.union(idOpenSite, idRight);
                }
            }
        }

        // connect to open bottom site
        if (row != sizeOfTheSite) {
            if (grid[i + 1][j] == OPEN) {
                int idBottom = xyToId(row + 1, col);
                if (!ufHelper.connected(idOpenSite, idBottom)) {
                    ufHelper.union(idOpenSite, idBottom);
                }

            }
        }

        // connect to open left site
        if (!((col == firstCol) || (row == sizeOfTheSite) || (row == firstRow))) {
            if (grid[i][j - 1] == OPEN) {
                int idLeft = xyToId(row, col - 1);
                if (!ufHelper.connected(idOpenSite, idLeft)) {
                    ufHelper.union(idOpenSite, idLeft);
                }
            }
        }

        // connect to open top site
        if (row != firstRow) {
            if (grid[i - 1][j] == OPEN) {
                int idTop = xyToId(row - 1, col);
                if (!ufHelper.connected(idOpenSite, idTop)) {
                    ufHelper.union(idOpenSite, idTop);
                }
            }

        }

    }
}
