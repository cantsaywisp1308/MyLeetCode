package trial;

public class Connected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{0,1,1,1},{1,0,1,1},{1,1,0,1},{1,1,1,0}};
		System.out.print(Connected(nums.length, nums));
	}
	
	public static boolean Connected(int n, int[][] matrix) {
		boolean status = false;
		if(n == 1) {
			status = true;
		} else if(!Connected(n-1, matrix)) {
				status = false;
		} else {
			for(int j = 0 ; j < n-1;j++) {
				if(matrix[n-2][j] == 1) {
					status = true;
				}
			}
		}
		return status;
	}
	

}
