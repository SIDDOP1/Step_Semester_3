public class Problem2_WarehouseGridSummary {
    // Returns {totalItems, maxRow, maxColumn}; row-major traversal keeps the first maximum.
    public static long[] warehouseSummary(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) throw new IllegalArgumentException("Grid cannot be empty");
        long total=0; int max= Integer.MIN_VALUE, maxRow=0, maxCol=0;
        for (int r=0;r<grid.length;r++) {
            if (grid[r]==null || grid[r].length!=grid[0].length) throw new IllegalArgumentException("Grid must be rectangular");
            for (int c=0;c<grid[r].length;c++) {
                int value=grid[r][c]; if(value<0) throw new IllegalArgumentException("Counts must be non-negative");
                total+=value;
                if(value>max){max=value;maxRow=r;maxCol=c;}
            }
        }
        return new long[]{total,maxRow,maxCol};
    }
    public static void main(String[] args) {
        long[] a=warehouseSummary(new int[][]{{4,9,2},{7,1,6},{3,12,5}});
        System.out.println("("+a[0]+", ("+a[1]+", "+a[2]+"))");
    }
}
// Time: O(m*n). Additional space: O(1).