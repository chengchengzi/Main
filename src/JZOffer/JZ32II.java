package JZOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JZ32II {
    /**
     * 面试题32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
     *   [9,20],
     *   [15,7]
     * ]
     * */
    /*
        借助队列
     */
     public List<List<Integer>> levelOrder(TreeNode root) {
         //利用currentEnd和nextNode结点来标记是否到达层结尾结点
         List<List<Integer>> list = new ArrayList<>();
         if(root == null){
             return list;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         TreeNode currentEnd = root;
         TreeNode nextEnd = root;
         List<Integer> tmp = new ArrayList<>();
         while(!queue.isEmpty()){
             TreeNode p = queue.poll();
             tmp.add(p.val);
             if(p.left != null){
                 queue.add(p.left);
                 nextEnd = p.left;
             }
             if(p.right != null){
                 queue.add(p.right);
                 nextEnd = p.right;
             }
             if(p == currentEnd){
                 list.add(new ArrayList<>(tmp));
                 tmp.clear();
                 currentEnd = nextEnd;
             }
         }
         return list;
         /*
         //另一种写法：利用队列的size()
         List<List<Integer>> list = new ArrayList<>();
         if(root == null){
             return list;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             int len = queue.size();
             int i = 0;
             ArrayList<Integer> tmp2 = new ArrayList<>();
             while(i < len && !queue.isEmpty()){
                TreeNode p = queue.poll();
                tmp2.add(p.val);
                if(p.left != null){
                     queue.add(p.left);
                }
                if(p.right != null){
                     queue.add(p.right);
                }
                i++;
             }
             list.add(tmp2);
         }
         return list;
     }
          */
     }
}
