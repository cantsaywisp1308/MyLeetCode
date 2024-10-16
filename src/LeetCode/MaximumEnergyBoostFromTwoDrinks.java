package LeetCode;

public class MaximumEnergyBoostFromTwoDrinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] energyDrinkA = {1,3,1};
		int[] energyDrinkB = {3,1,1};
		System.out.print(maxEnergyBoost(energyDrinkA, energyDrinkB));
	}
	
	public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
		if (energyDrinkA.length == 0 || energyDrinkB.length == 0) {
        	return 0;
        }
		long[] dpA = new long[energyDrinkA.length];
        long[] dpB = new long[energyDrinkB.length];
        dpA[0] = energyDrinkA[0];
        dpB[0] = energyDrinkB[0];
        
        for(int  i = 1; i < energyDrinkA.length; i++) {
        	dpA[i] = Math.max(dpA[i-1] + energyDrinkA[i], dpB[i-1]);
        	dpB[i] = Math.max(dpB[i-1] + energyDrinkB[i], dpA[i-1]);

        } 
        return Math.max(dpA[dpA.length-1], dpB[dpB.length-1]);
        
        
    }
}
