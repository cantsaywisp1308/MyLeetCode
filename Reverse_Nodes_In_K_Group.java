package LeetCode;

import java.util.*;

import LeetCode.ReversedLinkedList.ListNode;

public class Reverse_Nodes_In_K_Group {

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
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 3;
		ListNode root = new ListNode();
		insert(root, nums);
		display(reverseKGroup(root, k));

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		int count = list.size() / k;
		int pos = 0;
		for (int i = 1; i <= count; i++) {
			list = swapList(list, pos, k);
			pos += k;

		}
		ListNode res = new ListNode();
		insert(res, list);
		return res;
	}

	public static List<Integer> swapList(List<Integer> list, int start, int k) {
		for (int i = 0; i < k / 2; i++) {
			int temp = list.get(start + i);
			list.set(start + i, list.get(start + k - i- 1));
			list.set(start + k - i - 1, temp);
		}
		return list;
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
			if (i == val.size()-1) {
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
