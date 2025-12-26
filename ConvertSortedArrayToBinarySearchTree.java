package LeetCode;

public class ConvertSortedArrayToBinarySearchTree {

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

	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = new TreeNode();
		root = insertLevelOrder(nums, 0, nums.length-1);
		return root;
	}
	
	public static TreeNode insertLevelOrder(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = insertLevelOrder(nums, start, mid - 1);
		node.right = insertLevelOrder(nums, mid +1, end);
		return node;
	}

}
