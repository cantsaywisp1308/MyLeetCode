package LeetCode;
import java.util.*;

import LeetCode.PathSum.TreeNode;

public class PathSumII {

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
		int[] nums = {5,4,8,11,0,13,4,7,2,0,0,5,1};
		int target = 22;
		TreeNode root = insertLevelOrder(nums, 0);
		System.out.print(pathSum(root, target));
	}
	
	public static TreeNode insertLevelOrder(int[] arr, int i) {
		TreeNode root = null;
		if(i < arr.length) {
			if(arr[i] != 0) {
				root = new TreeNode(arr[i]);
			} else {
				root = null;
			}
			if(root != null) {
				root.left = insertLevelOrder(arr,2* i +1);
				root.right = insertLevelOrder(arr,2* i +2);
			}
			
		}
		return root;
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
		backtracking(root, res, 0,targetSum, new ArrayList<Integer>());
		return res;
    }

    public static List<List<Integer>> backtracking(TreeNode root, List<List<Integer>> res, int sum, int target, List<Integer> temp) {
		if(root == null) {
			return res;
		}
		temp.add(root.val);
		if(root.val + sum == target && root.left == null && root.right == null){
			res.add(new ArrayList<>(temp));
		}
		backtracking(root.right, res , sum+root.val,target,temp);
		backtracking(root.left, res, sum+root.val, target, temp);
		temp.remove(temp.size()-1);
		return res;		
	}

}
