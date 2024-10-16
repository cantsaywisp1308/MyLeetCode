package LeetCode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	

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
		int[] preorder = { 1 };
		int[] inorder = { 1 };
		inorderTraversal(buildTree(preorder, inorder));
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int preStart = 0;
		int preEnd = preorder.length - 1;
		return buildBinaryTree(preorder, preStart, preEnd, inorder, inStart, inEnd);
	}

	public static TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
			int inEnd) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}
		int rootValue = preorder[preStart];
		TreeNode node = new TreeNode(rootValue);

		int rootIndex = search(inorder, inStart, inEnd, node.val);
		node.left = buildBinaryTree(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart,
				rootIndex - 1);
		node.right = buildBinaryTree(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1,
				inEnd);
		return node;
	}

	public static int search(int[] arr, int start, int end, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void inorderTraversal(TreeNode node) {
		if (node != null) {
			inorderTraversal(node.left);
			System.out.print(node.val + " ");
			inorderTraversal(node.right);
		}
	}
}
