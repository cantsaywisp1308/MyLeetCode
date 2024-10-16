package LeetCode;
import java.util.*;

public class EliminationGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		System.out.print(lastRemaining(n));
	}
	
	public static int lastRemaining(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1;i <= n;i++) {
			list.add(i);
		}
		while(list.size() >1 ) {
			if (list.size() > 1) {
				list = deleteFromLeft(list);
			}
			if(list.size() > 1) {
				list = deleteFromRight(list);
			}
		}
		return list.get(0);
    }
	
	public static List<Integer> deleteFromLeft(List<Integer> list){
		for (int i = 0; i<list.size();i=i+2) {
			if(i == 0) {
				list.remove(i);
			} else {
				list.remove(i/2-1);
			}
		}
		
		return list;
	}
	
	public static List<Integer> deleteFromRight(List<Integer> list) {
		for(int i = list.size()-1; i>=0; i=i-2 ) {
			list.remove(i);
		}
		
		return list;
	}
	
	
}
