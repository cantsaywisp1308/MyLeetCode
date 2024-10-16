package LeetCode;
import java.util.*;

public class MinimumDepthOfBinaryTree {

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

	public static int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 1;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i = 0; i< levelSize;i++) {
				TreeNode currNode = queue.poll();
				if(currNode.left == null && currNode.right == null) {
					return depth;
				}
				if(currNode.left != null) {
					queue.offer(currNode.left);
				}
				if(currNode.right != null) {
					queue.offer(currNode.right);
				}
			}
			depth++;
		}
		return depth;
	}

}
