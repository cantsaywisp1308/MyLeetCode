package LeetCode;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,3}};
		int target = 3;
		System.out.print(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		boolean status = false;
		int[] nums = new int[matrix.length*matrix[0].length];
		for(int i = 0 ; i < matrix.length;i++) {
			int low = 0 ;
			int high = matrix[i].length-1;
			while(!status) {
				int mid = (low + high)/2;
				if(low > high || matrix[i][low] > target) {
					break;
				}
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
