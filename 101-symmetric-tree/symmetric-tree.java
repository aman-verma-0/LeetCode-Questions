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
    public boolean isSymmetric(TreeNode root) {
        return (root==null||isSymmetrical(root.left,root.right));    
    }
    public boolean isSymmetrical(TreeNode leftNode,TreeNode rightNode){
        if(leftNode==null && rightNode==null) return true;
        if(leftNode==null || rightNode==null) return false;
        if(leftNode.val!=rightNode.val) return false;
        return (isSymmetrical(leftNode.left,rightNode.right) && isSymmetrical(leftNode.right,rightNode.left));
    }
}