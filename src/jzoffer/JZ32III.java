package jzoffer;

import java.util.*;

public class JZ32III {
    /**
     * 面试题32 - III. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     *
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * @param root
     * @return
     */
    /*
        解题：准备两个栈，
        栈1逆序从右到左，先放左子树，后右子树；
        栈2顺序从左往右，先放右子树，后左子树。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(root);
        int level = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            if(level % 2 != 0) {
                while (!stack1.isEmpty()) {
                    TreeNode p = stack1.pop();
                    tmp.add(p.val);
                    if (p.right != null) {
                        stack2.push(p.right);
                    }
                    if (p.left != null) {
                        stack2.push(p.left);
                    }
                }
            }
            else{
                while(!stack2.isEmpty()){
                    TreeNode p = stack2.pop();
                    tmp.add(p.val);
                    if(p.left != null){
                        stack1.push(p.left);
                    }
                    if(p.right != null){
                        stack1.push(p.right);
                    }
                }
            }
            level++;
            list.add(tmp);
        }
        return list;
    }
}
