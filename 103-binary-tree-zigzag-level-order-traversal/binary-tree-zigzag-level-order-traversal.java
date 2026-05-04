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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>(Collections.nCopies(size,0));
            for(int i=0;i<size;i++){
                TreeNode curNode=q.poll();
                int index=leftToRight ? i :size-1-i;
                list.set(index,curNode.val);
                if(curNode.left!=null) q.add(curNode.left);
                if(curNode.right!=null) q.add(curNode.right);
            }
            leftToRight=!leftToRight;
            ans.add(list);

        }
        return ans;
        
    }
}