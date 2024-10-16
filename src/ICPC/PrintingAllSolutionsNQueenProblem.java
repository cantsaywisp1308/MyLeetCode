package ICPC;
import java.util.*;

public class PrintingAllSolutionsNQueenProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(4);
	}

	public static void print(int[][] board) {
        int count = 0;
        for (int[] row : board) {
            for (int el : row) {
                if (el == 1) {
                    count++;
                }
            }
        }
        // Not valid solution
        if (count != board.length) {
            return;
        }
 
        // Print the matrix
        for (int[] row : board) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
	
	public static boolean isSafe(int[][] board, int row, int col) {
		// validate rows
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
		
		for(i = row, j =col; i<board.length && j>=0;i++,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void saveBoard(int[][] board, List<List<String>> allBoard) {
		List<String> newBoard = new ArrayList<>();
		for(int i = 0 ; i < board.length;i++) {
			String row = "";
			for(int j = 0; j < board[0].length;j++) {
				if(board[i][j] == 1) {
					row+= "Q";
				} else {
					row+=".";
				}
			}
			newBoard.add(row);
		}
		allBoard.add(newBoard);
	}
	
	public static void solve(int[][] board, List<List<String>> allBoard, int col) {
		// if column length  becomes equal to board.length, that implies all the columns have been explored and function solve is ready with its solution.
		if(col == board.length) {
			saveBoard(board, allBoard);
			return;
		}
		
		for(int row = 0; row<board.length;row++) {
			if(isSafe(board, row, col)) {
				board[row][col] = 1;
				solve(board, allBoard, col+1);
				board[row][col] = 0;
			}
		}
	}
	
	public static void solution(int num) {
		List<List<String>> allBoards = new ArrayList<>();
		int[][] board = new int[num][num];
		solve(board, allBoards, 0);
		for(List<String> a : allBoards) {
			for(int i = 0; i < a.size();i++) {
				System.out.print(a.get(i));
			}
			System.out.println();
		}
	}
	
}
