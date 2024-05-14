package org.dsa.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
public class PrintTargetSumRootToLeaf {
    List<List<Integer>> result;
    List<Integer> list;
    public void helper(TreeNode root, int targetSum){

        if(root.left == null && root.right == null && targetSum == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(root.left != null){
            list.add(root.left.val);
            helper(root.left,targetSum-root.left.val);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            list.add(root.right.val);
            helper(root.right,targetSum-root.right.val);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();
        list = new ArrayList<>();
        if(root==null){
            return result;
        }
        list.add(root.val);
        helper(root,targetSum-root.val);
        return result;
    }
}
