package ICPC;
import java.util.*;
import java.util.List;

import LeetCode.SortList.ListNode;

public class MergeTwoSortedLists {

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
		int[] num1 = {1,2,3};
		int[] num2 = {1,3,4};
		ListNode listNode1 = new ListNode();
		ListNode listNode2 = new ListNode();
		insert(listNode1, num1);
		insert(listNode2,num2);
		display(mergeTwoLists(listNode1, listNode2));
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		List<Integer> num1 = new ArrayList<Integer>();
		while(list1 != null) {
			num1.add(list1.val);
			list1 = list1.next;
		}
		List<Integer> num2 = new ArrayList<Integer>();
		while(list2 != null) {
			num2.add(list2.val);
			list2 = list2.next;
		}
		for(int i = 0 ; i < num2.size(); i++) {
			num1.add(num2.get(i));
		}
		for(int i = 0; i < num1.size()-1;i++) {
			for(int j = i+1; j < num1.size();j++) {
				if(num1.get(i) > num1.get(j)) {
					int temp = num1.get(i);
					num1.set(i, num1.get(j));
					num1.set(j, temp);
				}
			}
		}
		ListNode res = new ListNode();
		if(num1.size() == 0) {
			res = null;
		} else {
			insert(res, num1);
		}
		return res;
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
