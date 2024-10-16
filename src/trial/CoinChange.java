package trial;

import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = { 1, 3, 5 };
		int amount = 9;

		List<List<Integer>> allSolutions = getAllSolutions(denominations, amount);

        if (allSolutions.isEmpty()) {
            System.out.println("No solution exists for the given denominations and amount.");
        } else {
            System.out.println("All solutions for making amount " + amount + ":");
            for (List<Integer> solution : allSolutions) {
                System.out.println(solution);
            }
        }

	}

	public static List<List<Integer>> getAllSolutions(int[] denominations, int amount) {
		List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= amount; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());

        for (int coin : denominations) {
            for (int i = coin; i <= amount; i++) {
                for (List<Integer> prevSolution : dp.get(i - coin)) {
                    List<Integer> temp = new ArrayList<>(prevSolution);
                    temp.add(coin);
                    dp.get(i).add(temp);
                }
            }
        }

        return dp.get(amount);
    }

}
