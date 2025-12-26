import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC101_Symmetric_Tree {

    static List<Integer> list = new ArrayList<>();

     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static void main(String[] args) {
        Integer[] arr = {1};
        TreeNode root = insertLevelOrder(arr);
        System.out.println(isSymmetric(root));
    }

    public static TreeNode insertLevelOrder(Integer[] arr) {
         if(arr == null || arr.length == 0 || arr[0] == null) {
            return null;
         }
         TreeNode root = new TreeNode(arr[0]);
         Queue<TreeNode> q = new ArrayDeque<>();
         q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();
            if(i < arr.length) {
                Integer leftVal = arr[i++];
                if (leftVal != null) {
                    node.left = new TreeNode(leftVal);
                    q.add(node.left);
                }
            }

            if(i < arr.length) {
                Integer rightVal = arr[i++];
                if(rightVal != null) {
                    node.right = new TreeNode(rightVal);
                    q.add(node.right);
                }
            }
        }
        return root;
    }

    public static boolean isSymmetric(TreeNode root) {
//         boolean status = true;
//         inOrderTraverse(root);
//         int mid = list.size()/2;
//         for (int i = 0; mid-i >= 0; i++) {
//             if(list.get(mid - i ) != list.get(mid + i)) {
//                 status = false;
//                 break;
//             }
//         }
//         return status;
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

//    public static void inOrderTraverse(TreeNode root) {
//         if(root == null) {
//             return ;
//         }
//         inOrderTraverse(root.left);
//         list.add(root.val);
//         inOrderTraverse(root.right);
//    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
         if(t1 == null && t2 == null) return true;
         if(t1 == null || t2 == null) return false;
         return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
