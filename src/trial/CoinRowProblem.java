package trial;

public class CoinRowProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5, 1, 2, 10, 6};
		System.out.print(CoinRow(array));
	}

	public static int CoinRow(int[ ] array) {
		int[] coin = new int[array.length+1];
		coin[0] = 0;
		coin[1] = array[0];
		for(int i = 2; i < coin.length;i++) {
			coin[i] = Math.max(coin[i-1], coin[i-2]+array[i-1]);
		}
		return coin[coin.length-1];
	}
	
	public static void printArray(int[] array) {
		for(int i = 0 ; i < array.length;i++) {
			System.out.print(array[i] + " ");
		}
	}
}
