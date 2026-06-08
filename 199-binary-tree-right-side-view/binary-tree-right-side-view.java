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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode cur=q.poll();
                if(i==0) ans.add(cur.val);
                if(cur.right!=null) q.add(cur.right);
                if(cur.left!=null) q.add(cur.left);

            }
        }
        return ans;
        
    }
}