package HackerRank;

public class RoadsBuilding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cities = 4;
		int[][] roads = {{0, 1}, {1, 2}, {2, 0}};
		System.out.print(solution(cities, roads));
	}
	
	public static int[][] solution(int cities, int[][] roads) {
		boolean[][] connection = new boolean[cities][cities];
		for(int i = 0; i < cities; i++) {
			connection[i][i] = true;
		}
		for(int[] road:roads) {
			connection[road[0]][road[1]] = true;
			connection[road[1]][road[0]] = true;
		}
		int count = 0;
		for(int i = cities-1; i >= 0; i--) {
			for(int j = cities-1 ; j >=i ; j--) {
				if(connection[i][j] == false) {
					count++;
				}
			}
		}
		int[][] result = new int[count][2];
		int k = 0;
		for(int i = 0 ; i < cities ; i++) {
			for(int j = i ; j < cities ; j++) {
				if(connection[i][j] == false) {
					result[k][0] = i;
					result[k][1] = j;
					k++;
				}
			}
		}
		return result;
	}

}
