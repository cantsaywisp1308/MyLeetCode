package ICPC;

public class NQueenProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQSolution();
	}
	
	public static boolean isSafe(int[][] board, int row, int col, int n) {
		int i,j;
		for(i = 0; i< col;i++) {
			if(board[row][i]==1) {
				return false;
			}
		}
		
		for(i = row, j = col; i>=0 && j >=0; i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		for(i = row, j =col; i<n && j>=0;i++,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean NQUtility(int[][] board, int col) {
		if(col >= board.length) {
			return true;
		}
		for(int i = 0;i<board.length;i++) {
			if(isSafe(board, i, col, board.length)) {
				board[i][col] = 1;
				if(NQUtility(board, col+1)) {
					return true;
				}
			}
			board[i][col] = 0;
		}
		return false;
	}
	
	public static boolean NQSolution() {
		int[][] board = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		if(!NQUtility(board, 0)) {
			System.out.print("Solution does not exist");
			return false;
		} else {
			printSolution(board);
			return true;
		}
		
	}
	
	public static void printSolution(int board[][])
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
	
}
