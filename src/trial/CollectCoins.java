package trial;

public class CollectCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {{0,-1,0,1,0,0},{1,0,0,-1,1,0},{1,1,0,-1,1,0},{0,0,0,1,0,1},{-1,-1,-1,0,1,0}};
		System.out.print(collectCoins(obstacleGrid));
	}
	
	public static int collectCoins(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] path = new int[m][n];
		
		for(int i = 1; i < m;i++) {
			if(obstacleGrid[i][0] == -1) {
				for(int j = i; j < m;j++) {
					path[j][0] = -1;
				}
				break;
			} else {
				path[i][0] = obstacleGrid[i][0] + path[i-1][0];
			}
		}
		
		for(int i = 1; i < n;i++) {
			if(obstacleGrid[0][i] == -1) {
				for(int j = i; j < n;j++) {
					path[0][j] = -1;
				}
				break;
			} else {
				path[0][i] = obstacleGrid[0][i] + path[0][i-1];
			}
		}
		
		for(int i =1; i< m; i++) {
			for(int j = 1; j < n;j++) {
				path[i][j] = obstacleGrid[i][j];
			}
		}
		
		for(int i = 1 ;i<m;i++) {
			for(int j = 1;j<n;j++) {
				if(path[i-1][j] == -1 && path[i][j-1] == -1) {
					path[i][j] = -1;
				} else {
					path[i][j] = Math.max(path[i-1][j], path[i][j-1]) + obstacleGrid[i][j];
				}
			}
		}
		return path[m-1][n-1];
	}

}
