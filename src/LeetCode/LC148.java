package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    */
    public ListNode sortList3(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        while(p.next != null){
            ListNode minNode = findMinNodeByBinary(p);
            int tmp = p.val;
            p.val = minNode.val;
            minNode.val = tmp;
            p = p.next;
        }
        return head;
    }

    public ListNode findMinNodeByBinary(ListNode p){
        ListNode endNode = p;
        while(endNode.next != null){
            endNode = endNode.next;
        }
        return findMinNodeByBinaryCore(p,endNode);
    }
    public  ListNode findMinNodeByBinaryCore(ListNode beginNode, ListNode endNode){
        if(beginNode.next == endNode){
            return beginNode.val < endNode.val ? beginNode : endNode;
        }
        ListNode mid = findMiddleNode(beginNode);
        ListNode leftMinNode = findMinNodeByBinaryCore(beginNode,mid);
        ListNode rightMinNode = findMinNodeByBinaryCore(mid.next,endNode);
        return leftMinNode.val < rightMinNode.val ? leftMinNode : rightMinNode;
    }
    public ListNode findMiddleNode(ListNode beginNode){
        ListNode slow = beginNode;
        ListNode fast = beginNode;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
