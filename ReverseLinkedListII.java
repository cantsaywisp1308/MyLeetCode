package LeetCode;
import java.util.*;
import java.util.List;

import LeetCode.RemoveDuplicatesFromSortedList.ListNode;

public class ReverseLinkedListII {

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
		int left = 2;
		int right = 4;
		ListNode head = new ListNode();
		insert(head,nums);
		display(reverseBetween(head, left, right));
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		int posLeft= left-1;
		int posRight = right-1;
		for(int i = 0;i < (right-left+1)/2;i++) {
			int temp = list.get(posLeft);
			list.set(posLeft, list.get(posRight));
			list.set(posRight, temp);
			posLeft++;
			posRight--;
		}
//		for(int i = left; i < (left+right)/2;i++) {
//			int temp = list.get(i);
//			list.set(i, list.get(right-i));
//			list.set(right-i, temp);
//		}
		ListNode res = new ListNode();
		if(list.size() == 0) {
			res = null;
		} else {
			insert(res, list);
		}
		return res;
	}
	
	public static void reverseList(List<Integer> list) {
		for(int i = 0 ; i < list.size();i++) {
			int temp = list.get(i);
			list.set(i, list.size()-i+1);
			list.set(list.size()-i+1, temp);
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
