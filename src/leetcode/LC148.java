package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class LC148 {
    /**
     * 148. 排序链表
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     */

    /*
        解法1：O(NlogN),O(N)
        1、借助List，顺序读取链表元素放入数组中
        2、对List排序
        3、对排序后的List重建链表
     */
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode res = new ListNode(list.get(0));
        ListNode p = res;
        for(int i = 1; i < list.size(); i++){
            ListNode tmp = new ListNode(list.get(i));
            p.next = tmp;
            p = p.next;

        }
        return res;
    }

    /*
        解法2：O(N^2),O(1)
        简单选择排序，顺序查找最小值，找第一小的值，与第一个结点值交换，然后找第二小的值，与第二个结点交换，...,
        一直到最后的结点
     */
    public ListNode sortList2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        while(p.next != null){
            ListNode findMinNode = p;
            ListNode minNode = p;
            while(findMinNode != null){
                if(findMinNode.val < minNode.val){
                    minNode = findMinNode;
                }
                findMinNode = findMinNode.next;
            }
            int tmp = p.val;
            p.val = minNode.val;
            minNode.val = tmp;
            p = p.next;
        }
        return head;
    }

    /*
       解法2：O(NlogN),O(1)
       快慢指针找中间结点，然后归并排序
       归并排序：
       1、找到中间结点，断开为左右两边
       2、分别对左右两边递归归并排序
       3、对排序后的左右两边
    */
    public ListNode sortList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddleNode(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList3(leftHead);
        ListNode right = sortList3(rightHead);
        return merge(left,right);
    }
    public ListNode findMiddleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode newList = new ListNode(-1);
        ListNode pNode = newList;
        while(left != null && right != null){
            if(left.val <= right.val){
                pNode.next = left;
                left = left.next;
            }else{
                pNode.next = right;
                right = right.next;
            }
            pNode = pNode.next;
        }
        if(left != null){
            pNode.next = left;
        }
        if(right != null){
            pNode.next = right;
        }
        return newList.next;
    }
}
