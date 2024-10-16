package trial;
import java.util.*;

import LeetCode.BinaryTreeInorderTraversal.TreeNode;

public class CountLevelOfBST {
	
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
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		TreeNode root = sortedArrayToBST(list);
		System.out.print(CountLevelsBST(root));
	}
	
	public static int CountLevelsBST(TreeNode root) {
		if (root == null) {
            // Empty tree
            return 0;
        }
        if (root.left == null && root.right == null) {
            // Single-node tree
            return 1;
        }
        
        int leftLevels = CountLevelsBST(root.left);
        int rightLevels = CountLevelsBST(root.right);
        
        return Math.max(leftLevels, rightLevels) + 1;
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
