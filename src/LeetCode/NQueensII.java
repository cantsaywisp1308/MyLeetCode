package LeetCode;
import java.util.*;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.print(solveQueens(n));
	}
	
	public static int solveQueens(int n) {
		List<List<String>> allBoard = new ArrayList<>();
		int[][] board = new int[n][n];
		solve(board, allBoard, 0);
		return allBoard.size();
	}
	
	public static boolean isSafe(int[][] board, int row, int col) {
		for(int i = 0; i < col;i++) {
			if(board[row][i] == 1) {
				return false;
			}
		}
		for(int i = row, j = col;i>=0 && j>=0;i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		for(int i = row,j=col;i<board.length&&j>=0;i++,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void saveBoard(int[][] board, List<List<String>> result) {
		List<String> row = new ArrayList<String>();
		for(int i = 0; i< board.length;i++) {	
			String r = "";
			for(int j = 0; j < board[0].length;j++) {
				if(board[i][j] == 1) {
					r += "Q";
				} else {
					r += ".";
				}
			}
			row.add(r);
		}
		result.add(row);
	}
	
	public static void solve(int[][] board, List<List<String>> allBoard, int col) {
		if(col == board.length) {
			saveBoard(board, allBoard);
			return;
		}
		for(int row = 0;row < board.length;row++) {
			if(isSafe(board,row,col)) {
				board[row][col] = 1;
				solve(board,allBoard,col+1);
				board[row][col] = 0;
			}
		}
	}

}
