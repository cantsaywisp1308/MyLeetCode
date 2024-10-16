package LeetCode;

public class ContructBinaryTreeFromInorderAndPostorderTraversal {

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
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		TreeNode node = buildNode(inorder, postorder, 0, n-1, 0, n-1);
		return node;
	}
	
	public static TreeNode buildNode(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart > inEnd) {
			return null;
		}
		TreeNode node = new TreeNode(post[postEnd]);
		if(inStart == inEnd) {
			return node;
		}
		int iIndex = search(in, inStart, inEnd, node.val);
		node.left = buildNode(in, post, inStart, iIndex-1, postStart, postStart - inStart + iIndex -1);
		node.right = buildNode(in, post, iIndex+1, inEnd, postEnd - inEnd + iIndex, postEnd-1);
		return node;
	}
	
	public static int search(int[] array, int start, int end, int value) {
		int i;
		for(i = start; i<=end;i++) {
			if(array[i] == value) {
				break;
			}
		}
		return i;
	}
	
	public static void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		preOrder(node.left);
		preOrder(node.right);
	}

}
