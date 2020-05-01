package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ32I {
    /**
     * 面试题32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
     * 返回：
     *
     * [3,9,20,15,7]
     */
    /*
        借助队列
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        ArrayList<Integer> list  = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            list.add(current.val);
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
