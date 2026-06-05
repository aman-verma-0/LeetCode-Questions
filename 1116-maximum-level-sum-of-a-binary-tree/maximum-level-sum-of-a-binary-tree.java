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
    public int maxLevelSum(TreeNode root) {
        int maxSum=Integer.MIN_VALUE;
        int ansLvl=0;
        int lvl=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            int curSum=0;
            lvl++;
            while(s-->0){
                TreeNode cur=q.poll();
                curSum+=cur.val;
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                
            }
            if(curSum>maxSum){
                maxSum=curSum;
                ansLvl=lvl;
            }
        }
        return ansLvl;
        
    }
}