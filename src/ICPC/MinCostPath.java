package ICPC;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println(minCost(cost,cost.length-1,cost[cost.length-1].length-1));
		System.out.print(minCost1(cost));
	}
	
	public static int min(int a, int b, int c) {
		int min = a;
		if(min > b) {
			min = b;
		}
		if(min > c) {
			min = c;
		}
		return min;
	}

	public static int minCost(int cost[][], int m, int n) { //applied for left down and diagon path
		if(m<0 || n <0) {
			return Integer.MAX_VALUE;
		} else if(m == 0 && n ==0) {
			return cost[m][n];
		} else {
			return cost[m][n] + min(minCost(cost,m-1,n), minCost(cost, m, n-1), minCost(cost, m-1, n-1));
		}
	}
	
	public static int minCost1(int[][] grid) { // applied for left and down only
		int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        
        return grid[m-1][n-1];
	}
	
	
}
