package LeetCode;

public class MatrixDiagonalSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		System.out.print(diagonalSum(mat));
	}

	public static int diagonalSum(int[][] mat) {
		if(mat.length%2==0) {
			return diagSumEven(mat);
		}else {
			return diagSumOdd(mat);
		}
	}
	
	public static int diagSumEven(int[][] mat) {
		int sum = 0;
		for(int i = 0; i<mat.length;i++) {
			sum+= mat[i][i];
		}
		int j = 0;
		for(int i = mat.length-1;i>=0;i--) {
			sum+= mat[j][i];
			j++;
		}
		return sum;
	}
	
	public static int diagSumOdd(int[][] mat) {
		int sum = 0;
		for(int i = 0; i<mat.length;i++) {
			sum+= mat[i][i];
		}
		int j = 0;
		for(int i = mat.length-1;i>=0;i--) {
			sum+= mat[j][i];
			j++;
		}
		return sum - mat[mat.length/2][mat.length/2];
	}
}
