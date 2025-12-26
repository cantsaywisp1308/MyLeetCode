package LeetCode;

import java.util.ArrayList;
import java.util.List;

import LeetCode.BinaryTreePreorderTraversal.TreeNode;

public class BinaryTreePostorderTraversal {
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
		int[] arr = {1,2,3};
		TreeNode root = insertLevelOrder(arr, 0);
		System.out.print(postorderTraversal(root));
	}
	
	public static TreeNode insertLevelOrder(int[] arr, int i) {
		TreeNode root = null;
		if(i < arr.length) {
			root = new TreeNode(arr[i]);
			root.left = insertLevelOrder(arr,2* i +1);
			root.right = insertLevelOrder(arr,2* i +2);
		}
		return root;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		postorderTraversalUtil(res, root);
		return res;
	}
	
	public static void postorderTraversalUtil(List<Integer> res, TreeNode root) {
		if(root == null) {
			return;
		}
		
		postorderTraversalUtil(res, root.left);
		postorderTraversalUtil(res, root.right);
		res.add(root.val);
	}

}
