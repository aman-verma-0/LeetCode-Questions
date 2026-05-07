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
    int maxDiff=0;
    public int maxAncestorDiff(TreeNode root) {
        int minValue=root.val;
        int maxValue=root.val;
        helper(root.left,minValue,maxValue);
        helper(root.right,minValue,maxValue);
        return maxDiff;
        
    }
    public void helper(TreeNode root,int minValue,int maxValue){
        if(root==null) return;
        int curValue=root.val;
        if(curValue<=minValue){
            minValue=Math.min(curValue,minValue);
            maxDiff=Math.max(maxDiff,maxValue-curValue);
            
        }else{
            maxValue=Math.max(maxValue,curValue);
            maxDiff=Math.max(maxDiff,curValue-minValue);

        }
        helper(root.left,minValue,maxValue);
        helper(root.right,minValue,maxValue);
    }
}