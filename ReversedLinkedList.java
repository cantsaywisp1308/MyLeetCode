package LeetCode;
import java.util.*;

public class ReversedLinkedList {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		ListNode root = new ListNode();
		insert(root,arr);
//		display(root);
		ListNode res = reverseList(root);
		display(res);
	}

	public static void display(ListNode root) {
		while (root != null)
	    {
	        System.out.print(root.val + " ");
	        root = root.next;
	    }
	}
	
	public static ListNode reverseList(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}

		ListNode res = new ListNode();
		insertReverse(res,list);
		return res;
	}
	
	public static void insertReverse(ListNode root, List<Integer> val) {
		for(int i = val.size()-1; i >=0 ;i--) {
			if(i == 0) {
				root.val = val.get(i);
			} else {
				root.val = val.get(i);
				root.next = new ListNode();
				root = root.next;
			}	
		}
		root = null;
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
}
