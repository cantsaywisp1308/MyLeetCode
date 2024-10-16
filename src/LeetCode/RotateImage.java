package LeetCode;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0; j <= i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[i].length/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length-j-1];
				matrix[i][matrix[i].length-j-1] = temp;
			}
		}
	}
	
	public static void print(int[][] matrix) {
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
