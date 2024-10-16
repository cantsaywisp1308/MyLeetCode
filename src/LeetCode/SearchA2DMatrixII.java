package LeetCode;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 20;
		System.out.print(searchMatrix(matrix, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		boolean status = false;
		for(int i = 0 ; i<matrix.length;i++) {
			int low = 0;
			int high = matrix[i].length-1;
			while(!status) {
				if(low > high) {
					break;
				}
				int mid = (low + high)/2;
				if(matrix[i][mid] < target) {
					low = mid +1;
				}
				if(matrix[i][mid] > target) {
					high = mid - 1;
				}
				if(matrix[i][mid] == target) {
					status = true;
					break;
				}
			}
			if(status == true) {
				break;
			}
		}
		return status;
	}

}
