package ICPC;

public class FindHeightofBinaryTree {
	

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

	public static TreeNode insertLevelOrder(int[] arr, int i)
    {
          TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
 
            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
 
    // Function to print tree nodes in InOrder fashion
    public static void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		TreeNode root = insertLevelOrder(nums, 0);
		inOrder(root);
		System.out.print(getHeightRecursive(root));
	}
	
	public static int getHeightRecursive(TreeNode root) {
		int height = 0;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                // If left subtree is null, move to right
                // subtree
                current = current.right;
                height++; // Increment the height of the
                          // tree
            }
            else {
                // Find the inorder predecessor of current
                // node
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
 
                if (pre.right == null) {
                    // Make current node the right child of
                    // its inorder predecessor
                    pre.right = current;
                    current = current.left;
                }
                else {
                    // If the right child of the inorder
                    // predecessor already points to the
                    // current node, then we have traversed
                    // the left subtree and its inorder
                    // traversal is complete.
                    pre.right = null;
                    current
                        = current.right; // Move to the
                                         // right subtree
                }
            }
        }
        return height;
	}

}
