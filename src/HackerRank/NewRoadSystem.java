package HackerRank;

public class NewRoadSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] roadRegister = 
						{{false, true,  false},
			                {false, false, false},
			                {true,  false, false}};
		System.out.print(NewRoadSystem(roadRegister));
	}
	
	public static boolean NewRoadSystem(boolean[][] roadRegister) {
		int[] rows = new int[roadRegister.length];
		int[] cols = new int[roadRegister.length];
		for(int i = 0; i < roadRegister.length; i++) {
			for(int j = 0; j < roadRegister.length; j++) {
				if(roadRegister[i][j] == true) {
					rows[i]++;
				}
			}
		}
		
		for(int i = 0; i < roadRegister.length; i++) {
			for(int j = 0; j < roadRegister.length; j++) {
				if(roadRegister[j][i] == true) {
					cols[i]++;
				}
			}
		}
		
		boolean result = true;
		for(int i = 0 ; i < rows.length; i++) {
			if(rows[i] != cols[i]) {
				result = false;
				break;
			}
		}
		return result;
	}

}
