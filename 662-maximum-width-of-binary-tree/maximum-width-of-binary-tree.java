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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int s=q.size();
            int leftMost=0;
            int rightMost=0;
            for(int i=0;i<s;i++){
                Pair cur=q.poll();
                TreeNode curNode=cur.node;
                int curIdx=cur.idx;
                if(i==0) leftMost=curIdx;
                if(i==s-1) rightMost=curIdx;
                if(curNode.left!=null) q.add(new Pair(curNode.left,2*curIdx+1));
                if(curNode.right!=null) q.add(new Pair(curNode.right,2*curIdx+2));
            }
            maxWidth=Math.max(maxWidth,rightMost-leftMost+1);
        }
        return maxWidth;

        
    }
}