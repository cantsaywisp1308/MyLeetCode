package trial;
import java.util.*;
public class ChocolateGame {
	
	public static class Player{
		String name;
		boolean turn;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isTurn() {
			return turn;
		}
		public void setTurn(boolean turn) {
			this.turn = turn;
		}
		public Player(String name, boolean turn) {
			super();
			this.name = name;
			this.turn = turn;
		}
		public Player() {
			super();
		}
		
	}
	
	public static class ChocolateBar{
		char[][] chocolateBar;
		int spoiledRow;
		int spoiledCol;
		int rows;
		int cols;
		public char[][] getChocolateBar() {
			return chocolateBar;
		}
		public void setChocolateBar(char[][] chocolateBar) {
			this.chocolateBar = chocolateBar;
		}
		public int getSpoiledRow() {
			return spoiledRow;
		}
		public void setSpoiledRow(int spoiledRow) {
			this.spoiledRow = spoiledRow;
		}
		public int getSpoiledCol() {
			return spoiledCol;
		}
		public void setSpoiledCol(int spoiledCol) {
			this.spoiledCol = spoiledCol;
		}
		public int getRows() {
			return rows;
		}
		public void setRows(int rows) {
			this.rows = rows;
		}
		public int getCols() {
			return cols;
		}
		public void setCols(int cols) {
			this.cols = cols;
		}
		public ChocolateBar(char[][] chocolateBar, int spoiledRow, int spoiledCol, int rows, int cols) {
			super();
			this.chocolateBar = chocolateBar;
			this.spoiledRow = spoiledRow;
			this.spoiledCol = spoiledCol;
			this.rows = rows;
			this.cols = cols;
		}
		public ChocolateBar() {
			super();
		}
		
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        // Create the matrix with dimensions m x n
        Random random = new Random();
        int randomRow = random.nextInt(m);
        int randomCol = random.nextInt(n);
        char[][] matrix = initializeChocolateBar(m, n, randomRow, randomCol);
        ChocolateBar chocolateBar = new ChocolateBar(matrix,randomRow, randomCol,m,n);
        displayMatrix(chocolateBar.getChocolateBar());
        playGame(chocolateBar, randomRow, randomCol);
	}
	
	public static void playGame(ChocolateBar chocolateBar, int randomRow, int randomCol) {
		Scanner scanner = new Scanner(System.in);
		Player player1 = new Player("player 1", true);
		Player player2 = new Player("player 2", false);
		boolean spoiledEaten = false;
		while(chocolateBar.getCols() * chocolateBar.getRows() > 2) {
			if(player1.isTurn() && !player2.isTurn()) {
				System.out.println("Player 1's turn: ");
			} else {
				System.out.println("Player 2's turn: ");
			}			//displayMatrix(matrix);
			 System.out.print("Enter the u or d or l or r: ");
			 char s = scanner.next().charAt(0);
			 while(s != 'u' && s != 'd' && s != 'l' && s != 'r') {
				 System.out.println("Invalid move -_-");
				 System.out.print("Enter the u or d or l or r: ");
				 s = scanner.next().charAt(0);
			 }
			 if(!makeMove(chocolateBar, s,randomRow ,randomCol, spoiledEaten)) {
				 switch(s) {
				 case 'u' :
					 chocolateBar.setRows(chocolateBar.getRows()-1);
					 chocolateBar.setSpoiledRow(chocolateBar.getSpoiledRow()-1);
					 chocolateBar.setChocolateBar(initializeChocolateBar(chocolateBar.getRows(), chocolateBar.getCols(), chocolateBar.getSpoiledRow(), chocolateBar.getSpoiledCol()));
					 break;
				
				 case 'd' :
					 chocolateBar.setRows(chocolateBar.getRows()-1);
					 chocolateBar.setChocolateBar(initializeChocolateBar(chocolateBar.getRows(), chocolateBar.getCols(), chocolateBar.getSpoiledRow(), chocolateBar.getSpoiledCol()));
					 break;
				
				 case 'l' :
					 chocolateBar.setCols(chocolateBar.getCols()-1);
					 chocolateBar.setSpoiledCol(chocolateBar.getSpoiledCol()-1);
					 chocolateBar.setChocolateBar(initializeChocolateBar(chocolateBar.getRows(), chocolateBar.getCols(), chocolateBar.getSpoiledRow(), chocolateBar.getSpoiledCol()));
					 break;
					 
				 case 'r' :
					 chocolateBar.setCols(chocolateBar.getCols()-1);
					 chocolateBar.setChocolateBar(initializeChocolateBar(chocolateBar.getRows(), chocolateBar.getCols(), chocolateBar.getSpoiledRow(), chocolateBar.getSpoiledCol()));
					 break;
				 }
			 } else {
				 if(player1.isTurn()) {
					 System.out.print("Player 1 lost!!!");
					 break;
				 } else {
					 System.out.print("Player 2 lost!!!");
					 break;
				 }

			 }
			 displayMatrix(chocolateBar.getChocolateBar());
			 System.out.println();
			 player1.setTurn(!player1.isTurn()); 
			 player2.setTurn(!player2.isTurn());
		}
		if(chocolateBar.getCols() * chocolateBar.getRows() == 2) {
			if(player1.isTurn()) {
				System.out.print("Player 2 lost!!!");
			}else {
				 System.out.print("Player 1 lost!!!");
			}
		}
	}
	
	public static char[][] initializeChocolateBar(int m, int n, int x, int y) {
		char[][] matrix = new char[m][n];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i == x && j == y) ? 'S' : 'O';
            }
        }
		return matrix;
    }
	
	public static void displayMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
	}
	
	public static boolean makeMove(ChocolateBar chocolateBar, char move, int x, int y, boolean spoiledEaten) {
        switch (move) {
            case 'u':
            	for(int i = 0 ; i<chocolateBar.getChocolateBar()[0].length;i++) {
            		if(chocolateBar.getChocolateBar()[0][i] == 'S') {
            			spoiledEaten = true;
            		}
            	}
                break;
            case 'd':
            	for(int i = 0 ; i<chocolateBar.getChocolateBar()[chocolateBar.getRows()-1].length;i++) {
            		if(chocolateBar.getChocolateBar()[chocolateBar.getRows()-1][i] == 'S') {
            			spoiledEaten = true;
            		}
            	}

                break;
            case 'l':
            	for(int i = 0 ; i<chocolateBar.getChocolateBar().length;i++) {
            		if(chocolateBar.getChocolateBar()[i][0] == 'S') {
            			spoiledEaten = true;
            		}
            	}    
                break;
            case 'r':
            	for(int i = 0 ; i<chocolateBar.getChocolateBar().length;i++) {
            		if(chocolateBar.getChocolateBar()[i][chocolateBar.getCols()-1] == 'S') {
            			spoiledEaten = true;
            		}
            	}

                break;
        }
        return spoiledEaten;
    }

}
