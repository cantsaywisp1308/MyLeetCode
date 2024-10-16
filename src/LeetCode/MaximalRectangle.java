package LeetCode;
import java.util.*;

public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
				{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.print(maximalRectangle(matrix));
	}
	
	public static int maximalRectangle(char[][] matrix) {
		int[][] hist = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length;i++) {
			for(int j = 0; j < matrix[0].length;j++) {
				hist[i][j] = matrix[i][j]-48;
			}
		}
		return maxRectangle(hist.length, hist[0].length,hist);
	}
	
	public static int maxHist(int R, int C, int[] row) {
		Stack<Integer> result = new Stack<Integer>();
		int top_val; //top of stack
		int max_area = 0; // Initialize max area in current row (or histogram)
		int area = 0; // Initialize area with current top
 
        // Run through all bars of given histogram (or row)
		int i = 0;
		while(i < C) {
			if(result.empty() || row[result.peek()] <= row[i]) {
				result.push(i++);
			} else {
				//If this bar is lower than top of stack,
                // then calculate area of rectangle with
                // stack top as the smallest (or minimum
                // height) bar. 'i' is 'right index' for the
                // top and element before top in stack is
                // 'left index'
				top_val = row[result.peek()];
				result.pop();
				area = top_val *i;
				if(!result.empty()) {
					area = top_val * (i - result.peek() - 1);
				}
				max_area = Math.max(area, max_area);
			}
		}
		// Now pop the remaining bars from stack and
        // calculate area with every popped bar as the
        // smallest bar
		while(!result.empty()) {
			top_val = row[result.peek()];
			result.pop();
			area = top_val *i;
			if(!result.empty()) {
				area = top_val * (i-result.peek()-1);
			}
			max_area = Math.max(area, max_area);
		}
		return max_area;
		
	}
	
	public static int maxRectangle(int R, int C, int[][] A) {
		int result = maxHist(R, C, A[0]);
		
		for(int i = 1; i < R;i++) {
			for(int j = 0; j < C;j++) {
				// if A[i][j] is 1 then add A[i -1][j]
				if(A[i][j] == 1) {
					A[i][j] += A[i-1][j];
				}
			}
			result = Math.max(result, maxHist(R, C, A[i]));
		}
		return result;
	}

}
