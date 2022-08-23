package leetcodeSimp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode2 treeone=new TreeNode2(1);
        TreeNode2 treetwo=null;
        System.out.println(isSameTree(treeone, treetwo));

    }

    public static boolean isSameTree(TreeNode2 p, TreeNode2 q)  {
        Deque<TreeNode2> treeone= new LinkedList<TreeNode2>();
        Deque<TreeNode2> treetwo=new LinkedList<TreeNode2>();
        Deque<TreeNode2> temptree=null;
        if(p==null){
            if(q==null){
                return  true;
            }
        }
        treeone.add(p);
        treeone.add(q);
        while(!treeone.isEmpty()){
            while(!treeone.isEmpty()){
                p= treeone.pop();
                q= treeone.pop();
                if(q!=null&&p.val==q.val){
                    if(p.left!=null){
                        treetwo.add(p.left);
                        treetwo.add(q.left);
                    }else if(q.left!=null){
                        return  false;
                    }

                    if(p.right!=null){
                        treetwo.add(p.right);
                        treetwo.add(q.right);
                    }else if(q.right!=null){
                        return  false;
                    }

                }else{
                    return false;
                }
            }
            temptree=treeone;
            treeone=treetwo;
            treetwo=temptree;

        }
        return true;
    }

}

 // Definition for a binary tree node.
 class TreeNode2 {
     int val;
     TreeNode2 left;
     TreeNode2 right;
     TreeNode2() {}
     TreeNode2(int val) { this.val = val; }
     TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

