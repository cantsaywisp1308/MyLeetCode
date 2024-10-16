package trial;

public class DescentTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {
	            {2},
	            {5, 4},
	            {1, 4, 7},
	            {8, 6, 9, 6}
	        };

	        // Finding the minimum descent sum
	        int minSum = minimumTotal(triangle);
	        System.out.println("The minimum descent sum is: " + minSum);
	}

	 public static int minimumTotal(int[][] triangle) {
	        int n = triangle.length;
	        int[][] dp = new int[n][n];

	        // Initialize the apex of the triangle
	        dp[0][0] = triangle[0][0];

	        // Build the dp table
	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j <= i; j++) {
	                // The leftmost element has only one adjacent element in the row above
	                if (j == 0) {
	                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
	                }
	                // The rightmost element has only one adjacent element in the row above
	                else if (j == i) {
	                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
	                }
	                // The middle elements have two adjacent elements in the row above
	                else {
	                    dp[i][j] = triangle[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
	                }
	            }
	        }

	        // Find the minimum total from the bottom row of the dp array
	        int minTotal = dp[n - 1][0];
	        for (int i = 1; i < n; i++) {
	            minTotal = Math.min(minTotal, dp[n - 1][i]);
	        }

	        return minTotal;
	    }
}
