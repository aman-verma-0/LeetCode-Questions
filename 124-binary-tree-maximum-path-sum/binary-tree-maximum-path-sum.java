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
    public int maxPathSum(TreeNode root) {
        int maxi[]={Integer.MIN_VALUE};
        findMaxPathSum(root,maxi);
        return maxi[0];
        
    }
    public int findMaxPathSum(TreeNode node ,int[]maxi){
        if(node==null) return 0;
        int leftSum=Math.max(0,findMaxPathSum(node.left,maxi));
        int rightSum=Math.max(0,findMaxPathSum(node.right,maxi));
        maxi[0]=Math.max(maxi[0],node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum,rightSum);
    }
}