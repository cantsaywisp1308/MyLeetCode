package LeetCode;

import java.util.ArrayList;
import java.util.List;

import LeetCode.RotateList.ListNode;



public class RemoveLinkedListElements {

	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7,7,7,7};
		int k = 7;
		ListNode root = new ListNode();
		insert(root, array);
		ListNode res = removeElements(root, k);
		display(res);
	}
	
	public static void insert(ListNode root, int[] val) {
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

	public static void display(ListNode root) {
		while (root != null)
	    {
	        System.out.print(root.val + " ");
	        root = root.next;
	    }
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
		root = null;
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i = 0; i < list.size();i++) {
			if(list.get(i) != val) {
				list1.add(list.get(i));
			}
		}
		ListNode res = new ListNode();
		if(list1.size() == 0) {
			res = null;
		} else {
			insert(res, list1);
		}	
		return res;
	}
}
