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
    public int averageOfSubtree(TreeNode root) {
        int totalNodes=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curNode =q.poll();
            int NoOfNodes=findNodes(curNode);
            int sum=findSum(curNode);
            int average=Math.round(sum/NoOfNodes);
            if(curNode.val==average) totalNodes++;
            if(curNode.left!=null) q.add(curNode.left);
            if(curNode.right!=null) q.add(curNode.right);
        }
        return totalNodes;
    }
    public int findNodes(TreeNode root){
        if(root==null) return 0;
        int left=findNodes(root.left);
        int right=findNodes(root.right);
        
        return 1+left+right;
    }
    public int findSum(TreeNode root){
        if(root==null) return 0;
        int leftSum=findSum(root.left);
        int rightSum=findSum(root.right);
        return root.val+leftSum+rightSum;
    }
}