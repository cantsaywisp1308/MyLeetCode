package LeetCode;
import java.util.*;

public class ConvertSortedListToBinarySearchTree {
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

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		TreeNode node = sortedArrayToBST(list);
		traverseInorder(node);
		
	}
	
	public static void traverseInorder(TreeNode node) {
		if(node == null) {
			return;
		}
		traverseInorder(node.left);
		System.out.print(node.val + " ");
		traverseInorder(node.right);
	}

	public static TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		if(list.isEmpty()) {
			return null;
		}
		return insertBalanced(list, 0, list.size()-1);
	}
	
	public static TreeNode sortedArrayToBST(List<Integer> values) {
	      if(values.isEmpty()) {
	          return null;
	      }
	      return insertBalanced(values, 0, values.size()-1);
	  }
	
	public static TreeNode insertBalanced(List<Integer> values, int start, int end) {
		if(start > end) {
		      return null;
		    }
		    int mid = (start + end)/2;
		    TreeNode node = new TreeNode(values.get(mid));
		    node.left = insertBalanced(values, start, mid-1);
		    node.right = insertBalanced(values, mid+1, end);
		    return node;
	}
}
