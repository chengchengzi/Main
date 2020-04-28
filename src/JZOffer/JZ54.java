package JZOffer;

import java.util.ArrayList;

public class JZ54 {
    /**
     * 面试题54. 二叉搜索树的第k大节点
     给定一棵二叉搜索树，请找出其中第k大的节点。   
     示例 1:
     输入: root = [3,1,4,null,2], k = 1
     3
     / \
     1   4
     \
        2
     输出: 4

     示例 2:
     输入: root = [5,3,6,2,4,null,null,1], k = 3
     5
     / \
     3   6
     / \
     2   4
     /
     1
     输出: 4

     限制：
     1 ≤ k ≤ 二叉搜索树元素个数
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
        O(nlogn),O(n)
        按中序递归遍历序列后的值放到list中,计数到第K个输出
     */
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //中序遍历访问
        inVisit(root,list);
        //返回K大的值
        return list.get(list.size() - k);
    }

    public void inVisit(TreeNode root, ArrayList<Integer> list){
        if(root != null){
            inVisit(root.left, list);
            list.add(root.val);
            inVisit(root.right,list);
        }
    }
}
