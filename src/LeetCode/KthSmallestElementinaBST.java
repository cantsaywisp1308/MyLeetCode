package LeetCode;

import java.util.PriorityQueue;

import LeetCode.BinaryTreePostorderTraversal.TreeNode;

public class KthSmallestElementinaBST {
	
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
		int[] arr = {5,3,6,2,4,0,0,1};
		TreeNode root = insertLevelOrder(arr, 0);
		System.out.print(kthSmallest(root, 3));
	}

	public static TreeNode insertLevelOrder(int[] arr, int i) {
		TreeNode root = new TreeNode();
		if(i < arr.length) {
			root = new TreeNode(arr[i]);
			root.left = insertLevelOrder(arr,2* i +1);
			root.right = insertLevelOrder(arr,2* i +2);
		}
		return root;
	}
	
	public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap = addtoQueue(minHeap, root);
        for(int i = 0; i < k-1 ;i++) {
        	minHeap.poll();
        }
        return minHeap.peek();
    }
	
	public static PriorityQueue<Integer> addtoQueue(PriorityQueue<Integer> minHeap, TreeNode root){
		if(root.val != 0) {
			minHeap.offer(root.val);
			minHeap = addtoQueue(minHeap, root.left);
			minHeap = addtoQueue(minHeap, root.right);
		}
		
		return minHeap;
	}
}
