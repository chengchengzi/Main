package JZOffer;

import java.util.LinkedList;
import java.util.Queue;

public class JZ55I {
    /**
     * 面试题55 - I. 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。。
     */
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    /*
        递归
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1: right + 1;
    }

    /*
        层序遍历
     */
    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        TreeNode currentEnd = root; //记录当前层的最右结点
        TreeNode nextEnd = root; //记录下一层的最右结点
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                queue.add(current.left);
                nextEnd = current.left;
            }
            if(current.right != null){
                queue.add(current.right);
                nextEnd = current.right;
            }
            if(current == currentEnd) {  //判断当前节点是否到达该层的最右节点，是则更新最右结点
                depth++;
                currentEnd = nextEnd;
            }
        }
        return depth;
    }
}
