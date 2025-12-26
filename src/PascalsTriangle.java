package LeetCode;

import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums = 34;
		System.out.print(generate(nums));
	}


	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		int[][] map = new int[numRows][numRows];
		for(int line = 0;line < numRows; line++) {
			for(int i = 0 ; i <= line;i++) {
				if(line == i || i == 0) {
					map[line][i] = 1;
				} else {
					map[line][i] = map[line-1][i] + map[line-1][i-1];
				}
			}
		}
		
		for(int i = 0; i < map.length;i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < map[i].length;j++) {
				if(map[i][j] != 0) {
					list.add(map[i][j]);
				}
			}
			result.add(list);
		}
		return result;
	}

}
