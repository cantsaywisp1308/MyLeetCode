package ICPC;
import java.util.*;

import LeetCode.Reverse_Nodes_In_K_Group.ListNode;

public class SwappingNodesInALinkedList {

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
		int[] nums = {7,9,6,6,7,8,3,0,9,5};
		int k =5;
		ListNode root = new ListNode();
		insert(root, nums);
		display(swapNodes(root, k));
	}
	
	public static ListNode swapNodes(ListNode head, int k) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		k--;
		if(k > list.size()/2) {
			k = list.size()-k-1;
		}
		int val = list.get(k);
		list.set(k, list.get(list.size()-k-1));
		list.set(list.size()-k-1, val);
		ListNode res = new ListNode();
		insert(res, list);
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
