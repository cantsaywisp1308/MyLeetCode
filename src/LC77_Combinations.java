import java.util.ArrayList;
import java.util.List;

public class LC77_Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n,k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(1, n, k, current, results);
        return results;
    }

    private static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = start; i <= n ; i++) {
            current.add(i);
            backtrack(i+1, n, k , current, result);
            current.remove(current.size()-1);
        }
    }
}
