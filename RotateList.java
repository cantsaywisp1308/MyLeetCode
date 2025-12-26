package LeetCode;
import java.util.*;

import LeetCode.ReversedLinkedList.ListNode;

public class RotateList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		int k = 0;
		ListNode root = new ListNode();
		insertArray(root, nums);
		ListNode res = rotateRight(root, k);
		display(res);
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0) {
			return head;
		} else {
			List<Integer> init = new ArrayList<Integer>();
			while(head != null) {
				init.add(head.val);
				head  = head.next;
			}
			
			k = k%init.size();
			List<Integer> temp = new ArrayList<Integer>();
			
			for(int i = 0; i < k;i++) {
				int value = init.get(init.size()-1);
				temp.add(value);
				init.remove(init.size()-1);
			}
			temp = reverseList(temp);
			for(int i = 0; i < init.size();i++) {
				temp.add(init.get(i));
			}
			
			ListNode res = new ListNode();
			insert(res, temp);
			return res;
		}
	}
	
	public static List<Integer> reverseList(List<Integer> list){
		for(int i = 0 ; i < list.size()/2;i++) {
			int temp = list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1,temp);
		}
		return list;
	}
	
	public static void insert(ListNode root, List<Integer> temp) {
		for(int i = 0; i < temp.size();i++) {
			if(i == temp.size()-1) {
				root.val = temp.get(i);
			} else {
				root.val = temp.get(i);
				root.next = new ListNode();
				root = root.next;
			}
		}
	}
	
	public static void display(ListNode root) {
		while (root != null)
	    {
	        System.out.print(root.val + " ");
	        root = root.next;
	    }
	}
	
	public static void insertArray(ListNode root, int[] val) {
		for(int i = 0; i < val.length;i++) {
			if(i == val.length-1) {
				root.val = val[i];
			} else {
				root.val = val[i];
				root.next = new ListNode();
				root = root.next;
			}
		}
		root = null;
	}

}
