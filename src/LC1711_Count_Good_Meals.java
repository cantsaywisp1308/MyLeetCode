import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1711_Count_Good_Meals {

    public static void main(String[] args) {
        int[] deliciousness = {1,1,1,3,3,3,7};
        System.out.println(countPairs(deliciousness));
    }

    public static int countPairs(int[] deliciousness) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < deliciousness.length; i++) {
            if(!map.containsKey(deliciousness[i])) {
                map.put(deliciousness[i], 1);
            } else {
                map.put(deliciousness[i], map.get(deliciousness[i]) + 1);
            }
        }
        List<List<Integer>> countEach = new ArrayList<>();
        for (int i : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(map.get(i));
            countEach.add(temp);
        }
        for (int i = 0 ; i < countEach.size()-1; i++) {

        }
        return (int) (result % (Math.pow(10,9) + 7));
    }

    public static boolean isPowOfTwo(long num) {
        if(num == 0) {
            return true;
        }
        for(int i = 0; i <= 21; i++) {
            if(Math.pow(2,i) == num) {
                return true;
            }
        }
        return false;
    }



}
