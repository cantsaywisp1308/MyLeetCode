package ICPC;

import javax.xml.XMLConstants;

public class AllKnightsTourPossibleFromAStartingPoint {
	
	static int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ChessBoard = new int[5][5];
		 
        int N = ChessBoard.length;
        int X = 3;
        int Y = 2;
 
        knightTour(ChessBoard, N, X - 1, Y - 1, 1);
 
        // If no valid sequence of moves exist
        if (isPossible == false) {
            System.out.println(-1);
        }
	}
	
	public static boolean isSafe(int x, int y, int[][] map) {
		return (x>=0 && x < map.length && y>=0 && y < map[0].length && map[x][y] == 0);
	}
	
	static boolean isPossible = false;
	
	public static void knightTour(int[][] map, int N,int x, int y, int visited) {
		map[x][y] = visited;
		if(visited == N*N) {
			isPossible = true;
			for(int i = 0; i<map.length;i++) {
				for(int j = 0;j<map[0].length;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			map[x][y] = 0;
			return;
		}
		
		for(int i = 0; i<8;i++) {
			int newX = x + xMove[i];
			int newY = y + yMove[i];
			if(isSafe(newX, newY, map) && map[newX][newY]==0) {
				knightTour(map, N, newX, newY, visited+1);
			}
		}
		
		map[x][y] = 0; //Backtrack
	}

}
