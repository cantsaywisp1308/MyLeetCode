package LeetCode;

import java.util.Arrays;

public class ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int numRows = 2;
		System.out.print(convert(s, numRows));
	}
	
	public static String convert(String s, int numRows) {
		if(numRows == 1) {
			return s;
		} else {
			char[][] arr = new char[numRows][1000];
			String res = "";
			int i = 0;
			int row=0;
			int col = 0;
			while(i < s.length()) {
				arr[row][col] = s.charAt(i);
				if(col%(numRows-1)==0 && row < numRows-1) {
					row++;
				} else if(row == numRows-1) {
					row--;
					col++;
				} else {
					row--;
					col++;
				}
				i++;
			}
			
			for(int r = 0 ; r<numRows;r++) {
				for(int c = 0;c<=col;c++) {
					if(arr[r][c] != 0) {
						res += arr[r][c];
					}	
				}
			}
			res.trim();
			return res;
		}
		
	}

}
