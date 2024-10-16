package LeetCode;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'5','.','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(board);
	}

	public static void solveSudoku(char[][] board) {
		int[][] board1 = new int[9][9];
		for(int i = 0 ;i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == '.') {
					board1[i][j] = 0;
				} else {
					board1[i][j] = board[i][j]- 48;
				}
			}
		}
		if(solve(board1, 0, 0)) {
			for(int i = 0 ;i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					board[i][j] = Character.forDigit(board1[i][j], 10);
				}
			}
		}
		print(board);
	}

	public static Boolean isValdMove(int[][] board, int row, int col, int number) {
		for(int i = 0; i <9; i++) {
			if(board[row][i] == number) {
				return false;
			}
		}
		for(int i = 0; i <9; i++) {
			if(board[i][col] == number) {
				return false;
			}
		}
		int corner_row = row - row % 3;
		int corner_col = col - col % 3;
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (board[corner_row+i][corner_col+j] == number) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solve(int[][] board, int row, int col) {
		if (col ==9) {
			if(row == 8) {
				return true;
			}
			row += 1;
			col = 0;
		}
		if(board[row][col] >0) {
			return solve(board, row, col+1);
		}
		for(char num = 1; num < 10;num++) {
			if(isValdMove(board, row, col, num)) {
				board[row][col] = num;
				if(solve(board, row, col+1)) {
					return true;
				}
			}
			board[row][col] = 0;
		}
		return false;
	}
	
	public static void print(char[][] board) {
		for(int i = 0 ; i < 9 ;i ++) {
			for(int j = 0 ; j < 9 ; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
