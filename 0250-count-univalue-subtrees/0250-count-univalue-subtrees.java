/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int count;
    static boolean go(TreeNode root){
        if (root == null) return true;
        boolean leftf = go(root.left);
        boolean rightf = go(root.right);
        if (leftf && rightf){
            if (root.left == null && root.right == null){
                count++;
                return true;
            }else if(root.left != null && root.right == null){
                if (root.left.val == root.val) {
                    count++;
                    return true;
                }else return false;
            }else if(root.left == null && root.right != null){
                if (root.right.val == root.val) {
                    count++;
                    return true;
                }else return false;
            }else {
                if (root.left.val == root.val && root.val == root.right.val){
                    count++;
                    return true;
                }else return false;
            }
        }else{
            return false;
        }
    }
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        if (root == null) return 0;
        go(root);
        return count;
    }
}