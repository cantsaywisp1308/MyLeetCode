package trial;

import LeetCode.ConvertSortedArrayToBinarySearchTree.TreeNode;

public class ContructBinaryTreeFromInorderAndPostorder {

	public static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = new int[] { 9,3,1,0,4,2,7,6,8,5 };
        int post[] = new int[] { 9,1,4,0,3,6,7,5,8,2};
        int n = in.length;
        Node root
            = buildUtil(in, post, 0, n - 1, 0, n - 1);
        System.out.println(
            "Preorder of the constructed tree : ");
        preOrder(root);
	}

	public static Node buildUtil(int in[], int post[], int inStrt, int inEnd, int postStrt, int postEnd) {
		// Base case
		if (inStrt > inEnd)
			return null;

		/*
		 * Pick current node from Postorder traversal using postIndex and decrement
		 * postIndex
		 */
		Node node = new Node(post[postEnd]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return node;
		int iIndex = search(in, inStrt, inEnd, node.data);

		/*
		 * Using index in Inorder traversal, construct left and right subtrees
		 */
		node.left = buildUtil(in, post, inStrt, iIndex - 1, postStrt, postStrt - inStrt + iIndex - 1);
		node.right = buildUtil(in, post, iIndex + 1, inEnd, postEnd - inEnd + iIndex, postEnd - 1);

		return node;
	}

	public static int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				break;
		}
		return i;
	}

	public static void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}
