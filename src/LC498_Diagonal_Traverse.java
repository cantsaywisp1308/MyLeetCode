import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC498_Diagonal_Traverse {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.print(findDiagonalOrder(mat));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> diagonal = new HashMap<>();

        for(int i = 0; i < mat.length; i++) {
            for (int j = 0 ; j < mat[i].length; j++) {

                diagonal.computeIfAbsent(i + j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        List<List<Integer>>diagons = new ArrayList<>(diagonal.values());
        for(int i = 0; i < diagons.size(); i++) {
            if(i%2 != 0) {
                for(int j = 0; j < diagons.get(i).size(); j++) {
                    result.add(diagons.get(i).get(j));
                }
            } else {
                for(int j = diagons.get(i).size() - 1; j >= 0; j--) {
                    result.add(diagons.get(i).get(j));
                }
            }
        }

        int[] res = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return  res;
    }
}
