package leetcodeSimp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
前序遍历：中，左，右
中序遍历：左，中，右
后序遍历：左，右，中
 */

public class TreeTravel {


}
// Definition for a binary tree node.
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//递归
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode1 root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode1 root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode1 root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode1> stk = new LinkedList<TreeNode1>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

class Solution3 {
    public List<Integer> inorderTraversal(TreeNode1 root) {
        List<Integer> res=new ArrayList<Integer>();
        TreeNode1 predecessor=null;
        while(root!=null){
            if(root.left!=null){
                predecessor=root.left;
                while(predecessor.right!=null&&predecessor.right!=root){
                    predecessor=predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right=root;
                    root=root.left;
                }else{
                    res.add(root.val);
                    predecessor.right=null;//复原数
                    root=root.right;
                }

            }else{
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }
}
