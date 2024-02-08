package LeetCode;

public class ConstructTheRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int area = 122122;
		printArray(constructRectangle(area));
	}

	public static int[] constructRectangle(int area) {
		int w;
		int l;
		int[] res = new int[2];
		int minDifference = Integer.MAX_VALUE;
		for(w = 1; w <= Math.sqrt(area);w++) {
			if(area%w ==0 ) {
				l = area/w;
				int difference = Math.abs(l-w);
				if(difference < minDifference) {
					minDifference = difference;
					res[0] = l;
					res[1] = w;
				}
			}
		}
		return res;
	}
	
	public static void printArray(int[] arr) {
		System.out.print(arr[0] + " " + arr[1]);
	}
}
