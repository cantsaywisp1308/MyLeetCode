package ICPC;

public class TheKnightTourProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();
	}
	
	public static boolean isSafe(int x, int y, int[][] map) {
		return(x >= 0 && x< map.length && y >=0 && y<map[0].length && map[x][y] == -1);
	}
	
	public static void printSolution(int[][] map) {
		for(int i = 0 ; i < map.length;i++) {
			for(int j = 0 ; j < map[0].length; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static boolean solve() {
		int[][] map = new int[8][8];
		for(int i = 0;i<map.length;i++) {
			for(int j = 0; j<map[0].length;j++) {
				map[i][j] = -1;
			}
		}
		
		int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
		
		map[0][0] = 0;
		
		if(!solveUtility(0, 0, 1, map, xMove, yMove)) {
			return false;
		} else {
			printSolution(map);
		}
		
		return true;
		
	}
	
	public static boolean solveUtility(int x, int y, int move, int[][] map, int[] xMove, int[] yMove) {
		int next_x, next_y;
		if(move == map.length * map[0].length) {
			return true;
		}
		
		for(int i = 0 ; i< 8;i++) {
			next_x = x + xMove[i];
			next_y = y + yMove[i];
			if(isSafe(next_x, next_y, map)) {
				map[next_x][next_y] = move;
				if(solveUtility(next_x, next_y, move+1, map, xMove, yMove)) {
					return true;
				} else {
					map[next_x][next_y] = -1;
				}
			}
		}
		
		return false;
	}

}
