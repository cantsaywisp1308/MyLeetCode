package LeetCode;
import java.util.*;

import LeetCode.ReversedLinkedList.ListNode;

public class ReorderList {

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
		int[] arr = {1,2,3,4};
		ListNode root = new ListNode();
		insert(root,arr);
		reorderList(root);
		display(root);
	}

	public static void display(ListNode root) {
		while (root != null)
	    {
	        System.out.print(root.val + " ");
	        root = root.next;
	    }
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
	
	public static void reorderList(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		ListNode newNode = head;
		while(newNode != null) {
			list.add(newNode.val);
			newNode = newNode.next;
		}
		newNode = head;
		int n = list.size();
		for(int i = 0 ; i < n/2;i++) {
			newNode.val = list.get(i);
			newNode = newNode.next;
			newNode.val = list.get(n-i-1);
			newNode = newNode.next;
		}
		if(n%2==1) {
			newNode.val = list.get(n/2);
		}
	}
	
	public static ListNode reorderUtil(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		int val = list.get(list.size()-1);
		list.remove(list.size()-1);
		list.add(1, val);
		ListNode res = new ListNode();
		for(int i = 0; i < list.size();i++) {
			if(i == list.size()-1) {
				res.val = list.get(i);
			} else {
				res.val = list.get(i);
				res.next = new ListNode();
				res = res.next;
			}
		}
		return res;
	}
}
