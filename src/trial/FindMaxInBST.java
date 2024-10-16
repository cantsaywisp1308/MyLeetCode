package trial;

public class FindMaxInBST {

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

	public static class Index {
		int index = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {  10, 5, 1, 7, 40, 50 };
		Index index = new Index();
		TreeNode node = constructBST(nums, index, 0, nums.length - 1, nums.length);
		//printBSTPreorder(node);
		System.out.print(findMaxBST(node));
	}

	public static TreeNode constructBST(int[] nums, Index preIndex, int low, int high, int size) {
		if (preIndex.index >= size || low > high) {
			return null;
		}

		TreeNode root = new TreeNode(nums[preIndex.index]);
		preIndex.index = preIndex.index + 1;

		if (low == high) {
			return root;
		}
		int i = 0;
		for (i = low; i <= high; i++) {
			if (nums[i] > root.val) {
				break;
			}
		}

		root.left = constructBST(nums, preIndex, preIndex.index, i - 1, size);
		root.right = constructBST(nums, preIndex, i, high, size);
		return root;
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		Index index = new Index();
		return constructBST(preorder, index, 0, preorder.length-1, preorder.length);
	}
	
	public static int findMaxBST(TreeNode root) {
		int max = root.val;
		if(root.right != null) {
			max = findMaxBST(root.right);
		}
		return max;
	}

	public static void printBSTPreorder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printBSTPreorder(node.left);
		printBSTPreorder(node.right);
	}
}
