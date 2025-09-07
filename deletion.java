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
    public void deletion(TreeNode root,int target){
        if(root==null) return;
        if(root.left!=null && root.left.val==target){
            TreeNode l=root.left;
            if(l.left==null && l.right==null) root.left=null;//0 child
            else if(l.left==null || l.right==null){//1 child
                if(l.left!=null) root.left=l.left;
                else root.left=l.right;
            }
            else{// 2 child
                TreeNode curr=l;
                TreeNode pred=curr.left;
                while(pred.right!=null) pred=pred.right;
                deletion(root,pred.val);
                pred.left=curr.left;
                pred.right=curr.right;
                root.left=pred;
            }
        }
        else deletion(root.left,target);

            if(root.right!=null && root.right.val==target){
                TreeNode r=root.right;
                if(r.left==null && r.right==null) root.right=null;//0child
                else if(r.left==null || r.right==null){1 child
                    if(r.left!=null) root.right=r.left;
                    else root.right=r.right;
                }
                else{//2 child
                TreeNode curr=r;
                TreeNode pred=curr.right;
                while(pred.left!=null) pred=pred.left;
                deletion(root,pred.val);
                pred.left=curr.left;
                pred.right=curr.right;
                root.right=pred;
            }}else deletion(root.right,target);
        
    }
    public TreeNode deleteNode(TreeNode root, int target) {
       TreeNode temp=new TreeNode(Integer.MAX_VALUE);
       temp.left=root;
        deletion(temp,target);
        root=temp.left;
        return root;
    }
}
