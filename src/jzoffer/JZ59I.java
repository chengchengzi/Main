package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

public class JZ59I {
    /**
     * 面试题59 - I. 滑动窗口的最大值
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 提示：
     *
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     */
    /*
        解法一：O(n*k)
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        int index = 0;
        while(right < nums.length){
            int max = nums[left];
            for(int j = left + 1;j <= right; j++){ //滑动窗口的最大值
                if(nums[j] > max){
                    max = nums[j];
                }
            }
            res[index++] = max;
            left++;
            right++;
        }
         return res;
    }

    /*
    解法二：O(n),O(k),使用双端队列
        1、维护一个长度为k的双端队列，队列的头为窗口的最大值
        2、i，j用户标记窗口滑动，i = [0 - k + 1,n - k + 1], j = [0, n - 1];
        3、当i>0且当前队列头deque[0]与nums[i - 1]相等，说明此时deque[0]不在当前滑动窗口中，
         因为队列中的值仅为当前滑动窗口i-j内的值
        4、当nums[j] > 队尾元素,队尾出队，因为要保持队头是最大值
        5、（队列为空 || nums[j] < 队尾）队尾入队nums[j],
        6、当i>=0, 形成窗口,此后，每次移动，都保存队列最大值
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0 - k + 1, j = 0; j < nums.length; i++,j++){ //2
            if(i > 0 && deque.getFirst() == nums[i - 1]){ //3
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[j] > deque.getLast()){ //4
                deque.removeLast();
            }
            deque.addLast(nums[j]); //5
            if(i >= 0){
                res[index++] = deque.getFirst();
            }
        }
        return res;
    }



}
