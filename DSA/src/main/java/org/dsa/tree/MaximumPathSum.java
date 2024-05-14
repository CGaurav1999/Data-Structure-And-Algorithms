package org.dsa.tree;


public class MaximumPathSum {
    static int ans = 0;
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = root.left != null ? helper(root.left) : -1000;
        int right = root.right != null ? helper(root.right) : -1000;

        int temp = Math.max(right,left);

        ans = Math.max(ans,temp);
        ans = Math.max(ans,left+right+root.val);
        ans = Math.max(ans,root.val);
        ans = Math.max(ans,temp+root.val);

        return temp + root.val > root.val ? temp + root.val : root.val;
    }
    public int maxPathSum(TreeNode root) {
        ans = -1000;
        helper(root);
        return ans;
    }
}
