import java.util.ArrayList;
import java.util.List;

public class LC56_Merge_Interval {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);
        outputArray(result);
    }

    public static int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }

        List<List<Integer>> newIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[i][0]);
            interval.add(intervals[i][1]);
            newIntervals.add(interval);
        }

        int i = 0;
        while(i+1 < newIntervals.size()) {
            if(newIntervals.get(i).get(1) >= newIntervals.get(i+1).get(0)) {
                if(newIntervals.get(i).get(1) <= newIntervals.get(i+1).get(1)) {
                    newIntervals.get(i).set(1, newIntervals.get(i+1).get(1));
                }
                newIntervals.remove(i+1);
            } else {
                i++;
            }
        }


        int[][] result = new int[newIntervals.size()][2];
        for (int a = 0; a < newIntervals.size(); a++) {
            for (int j = 0; j < 2; j++) {
                result[a][j] = newIntervals.get(a).get(j);
            }
        }
        return result;
    }

    public static void outputArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.print("]");
        }
    }
}
