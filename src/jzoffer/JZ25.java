package jzoffer;

import leetcode.ListNode;

public class JZ25 {
    /**
     * 面试题25. 合并两个排序的链表
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 限制：
     *
     * 0 <= 链表长度 <= 1000
     */

    /*
        解法1：O(m+n),O(1)
        1、依次遍历，把值小的结点加入到新链表中
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        ListNode newHead = new ListNode(-1);
        ListNode pNode = newHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pNode.next = l1;
                l1 = l1.next;
            }else{
                pNode.next = l2;
                l2 = l2.next;
            }
            pNode = pNode.next;
        }
        if(l1 != null){
            pNode.next = l1;
        }
        if(l2 != null){
            pNode.next = l2;
        }
        return newHead.next;
    }

    /*
        解法2：O（M + N）,O(M + N)
            递归
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p;
        if(l1.val <= l2.val){
            p = l1;
            p.next = mergeTwoLists(l1.next,l2);
        }else{
            p = l2;
            p.next = mergeTwoLists(l1,l2.next);
        }
        return p;
    }
}
