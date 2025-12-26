package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 0;
		System.out.print(getRow(row));
	}
	
	public static List<Integer> getRow(int rowIndex){
		List<List<Integer>> result = new ArrayList<>();
		int[][] map = new int[rowIndex+1][rowIndex+1];
		for(int line = 0;line <= rowIndex; line++) {
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
		return result.get(rowIndex);
	}

}
