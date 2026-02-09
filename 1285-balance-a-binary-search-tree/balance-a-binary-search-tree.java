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
    public TreeNode balanceBST(TreeNode root) {
        List <Integer> list=new ArrayList<>();
        inOrder(root,list);
        return buildBalanced(list,0,list.size()-1);    
    }
    public void inOrder(TreeNode root,List<Integer>list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public TreeNode buildBalanced(List<Integer>list,int left,int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=buildBalanced(list,left,mid-1);
        root.right=buildBalanced(list,mid+1,right);
        return root;

    }
}