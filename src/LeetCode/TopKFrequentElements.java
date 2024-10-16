package LeetCode;

import java.util.*;
import java.util.Map;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		print(topKFrequent(nums, 1));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		int[] result = new int[k];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int value = map.get(nums[i]);
				value++;
				map.put(nums[i], value);
			}
		}
		int i = 0;
		HashMap<Integer, Integer> hashMap = sortByValue(map);
		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if( i == k) {
				break;
			}
			result[i] = entry.getKey();
			i++;
			
		}
		return result;
	}
	
	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, 
                               Map.Entry<Integer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // put data from sorted list to hashmap 
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	private static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
