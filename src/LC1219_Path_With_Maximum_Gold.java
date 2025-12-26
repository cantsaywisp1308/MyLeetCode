import java.util.ArrayList;
import java.util.List;

public class LC1219_Path_With_Maximum_Gold {

    static int[][] directions = {
            {1,0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int maxGold = 0;
    public static void main(String[] args) {
        int[][] gold = {
                        {34,0,1,0,0,0},
                        {0,0,2,0,1,0},
                        {5,4,3,7,4,2},
                        {0,0,5,0,1,4},
                        {0,0,5,0,2,3}};
//        int[][] grid = {{1,0,1},{1,0,1},{1,1,1},{0,1,0},{1,0,1}};
//        findAllWays(grid, gold);
        System.out.println(getMaximumGold(gold));
    }

//    public static void findAllWays(int[][] grid, int[][] gold) {
//        for (int i = 0 ; i < grid.length; i++) {
//            for (int j = 0 ; j < grid[i].length; j++) {
//                if(grid[i][j] == 1) {
//                    int currentGold = 0;
//                    List<String> path = new ArrayList<>();
//                    path.add("(" + i + ", " + j + ")");
//                    boolean[][] visited = new boolean[grid.length][grid[i].length];
//                    visited[i][j] = true;
//
//                    System.out.println("Starting from (" + i + ", " + j + "):");
//                    dfs(i, j, path, visited, grid, gold, gold[i][j]);
//                    System.out.println();
//                }
//            }
//        }
//        System.out.print("Max gold: " + maxGold);
//    }
//
//    private static void dfs(int r, int c, List<String> path, boolean[][] visited, int[][] grid, int[][] gold ,int currentGold) {
//        boolean extended = false;
//        for (int[] dir : directions) {
//            int nr = r + dir[0];
//            int nc = c + dir[1];
//            if (isValid(nr, nc, grid) && !visited[nr][nc]) {
//                extended = true;
//                path.add("(" + nr + "," + nc + ")");
//                visited[nr][nc] = true;
//                dfs(nr, nc, path, visited, grid, gold, currentGold + gold[nr][nc]);
//                path.remove(path.size() - 1);
//                visited[nr][nc] = false;
//            }
//        }
//
//        // If no further moves, print and update max
//        if (!extended) {
//            System.out.println(String.join(" -> ", path) + " gold: " + currentGold);
//            maxGold = Math.max(maxGold, currentGold);
//        }
//    }
//
    private static boolean isValid(int r, int c, int[][] grid) {
        return r>=0 && r< grid.length && c >=0 && c < grid[r].length && grid[r][c] != 0;
    }

    public static int getMaximumGold(int[][] grid) {
        maxGold = 0;
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    boolean[][] visited = new boolean[grid.length][grid[i].length];
                    visited[i][j] = true;
                    dfs(i, j, visited, grid, grid[i][j]);
                }
            }
        }
        return maxGold;
    }

    private static void dfs(int r, int c, boolean[][] visited, int[][] grid, int currentGold) {
        boolean extended = false;
        for (int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(isValid(nr, nc, grid) && !visited[nr][nc]) {
                extended = true;
                visited[nr][nc] = true;
                dfs(nr, nc, visited, grid, currentGold + grid[nr][nc]);
                visited[nr][nc] = false;
            }
        }

        if(!extended) {
            maxGold = Math.max(currentGold, maxGold);
        }
    }
}
