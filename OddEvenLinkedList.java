package LeetCode;
import java.util.*;
import java.util.List;

import LeetCode.ReverseLinkedListII.ListNode;

public class OddEvenLinkedList {

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
		int[] nums = {1,2,3,4,5};
		ListNode root = new ListNode();
		insert(root, nums);
		root = oddEvenList(root);
		display(root);
	}
	
	 public static ListNode oddEvenList(ListNode head) {
		 if(head == null) {
			 return null;
		 } else {
			 List<Integer> evenList = new ArrayList<Integer>();
			 List<Integer> oddList = new ArrayList<Integer>();
			 
			 int count = 0;
			 while(head != null) {
				 if(count % 2 == 0) {
					 evenList.add(head.val);
				 } else {
					 oddList.add(head.val);
				 }
				 count++;
				 head = head.next;
			 }
			 List<Integer> list = evenList;
			 list.addAll(oddList);
			 ListNode res = new ListNode();
			 insert(res,list);
			 return res;
		 }
	 }
	
	public static void insert(ListNode root, int[] val) {
		for (int i = 0; i < val.length; i++) {
			if (i == val.length - 1) {
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
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}

	public static void insert(ListNode root, List<Integer> val) {
		for (int i = 0; i < val.size(); i++) {
			if (i == val.size() - 1) {
				root.val = val.get(i);
			} else {
				root.val = val.get(i);
				root.next = new ListNode();
				root = root.next;
			}
		}
		root = null;
	}


}
