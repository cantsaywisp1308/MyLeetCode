package LeetCode;
import java.util.*;
import java.util.List;

import ICPC.SwappingNodesInALinkedList.ListNode;

public class SortList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9,12,34,56,77,88,111,221,10};
		ListNode root = new ListNode();
		insert(root, nums);
		display(sortList(root));
	}
	
	public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head != null) {
        	list.add(head.val);
        	head = head.next;
        }
        sort(list);
        ListNode res = new ListNode();
        if(list.size() == 0) {
			res = null;
		} else {
			insert(res, list);
		}
		return res;
    }
	
	public static void sort(List<Integer> arr)
    {
        int N = arr.size();
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
	
	public static void heapify(List<Integer> arr, int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr.get(l) > arr.get(largest))
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr.get(r) > arr.get(largest))
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
 
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

	public static void insert(ListNode root, int[] val) {
		for (int i = 0; i < val.length; i++) {
			if (i == val.length - 1) {
				root.val = val[i];
			} else {
				root.val = val[i];
				root.next = new ListNode();
				root = root.next;
			}
		}
		root = null;
	}

	public static void display(ListNode root) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}

	public static void insert(ListNode root, List<Integer> val) {
		for (int i = 0; i < val.size(); i++) {
			if (i == val.size() - 1) {
				root.val = val.get(i);
			} else {
				root.val = val.get(i);
				root.next = new ListNode();
				root = root.next;
			}
		}
		root = null;
	}

}