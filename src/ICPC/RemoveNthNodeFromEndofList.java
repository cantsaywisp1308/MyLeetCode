package ICPC;
import java.util.*;

import ICPC.SwappingNodesInALinkedList.ListNode;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		int n = 2;
		ListNode root = new ListNode();
		insert(root, nums);
		display(removeNthFromEnd(root, n));
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		n--;
		list.remove(list.size()-1-n);
		ListNode res = new ListNode();
		if(list.size() == 0) {
			res = null;
		} else {
			insert(res, list);
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
