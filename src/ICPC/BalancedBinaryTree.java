package ICPC;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class BalancedBinaryTree {

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
		int[] arr = {1,2,2,3,3,0,0,4,4};
		TreeNode tree = insertLevelOrder(arr, 0);
		System.out.print(isBalanced(tree));
	}
	
	public static TreeNode insertLevelOrder(int[] arr, int i) {
		TreeNode root = new TreeNode(0); //LeetCode TreeNode root = null;
		if(i < arr.length) {
			root = new TreeNode(arr[i]);
			root.left = insertLevelOrder(arr,2* i +1);
			root.right = insertLevelOrder(arr,2* i +2);
		}
		return root;
	}
	
	public static boolean isBalanced(TreeNode root) {
        int lh;
        int rh;
        if(root.val == 0) {
        	return true;
        }
        lh = height(root.left);
        rh = height(root.right);
        isBalanced(root.left);
        isBalanced(root.right);
        if(Math.abs(lh - rh)<= 1 && isBalanced(root.left) && isBalanced(root.right)) {
        	return true;
        }
        return false;
    }
	
	public static int height(TreeNode root) {
		if (root.val == 0) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

}
