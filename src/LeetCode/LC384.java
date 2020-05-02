package LeetCode;

import java.util.ArrayList;
import java.util.Random;

public class LC384 {
    /**
     * 打乱一个没有重复元素的数组。
     *
     * 示例:
     *
     * // 以数字集合 1, 2 和 3 初始化数组。
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     *
     * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * solution.shuffle();
     *
     * // 重设数组到它的初始状态[1,2,3]。
     * solution.reset();
     *
     * // 随机返回数组[1,2,3]打乱后的结果。
     * solution.shuffle();
     *
     */
    class Solution {
        int[] nums;
        int[] numsCopy;

        public Solution(int[] nums) {
            this.nums = new int[nums.length];
            this.numsCopy = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                this.nums[i] = nums[i];
                this.numsCopy[i] = nums[i];
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return numsCopy;
        }

        /** Returns a random shuffling of the array. */
        /*
        每次产生一个随机数下标，依次放到0-nums.length-1里，
        然后删除这个已经打乱过的数，重复，直到nums.length - 1.
         */
        public int[] shuffle() {
            Random rand = new Random();
            for(int i = 0; i < nums.length; i++){
                int ran = rand.nextInt(nums.length - i) + i;
                int tmp = nums[i];
                nums[i] = nums[ran];
                nums[ran] = tmp;
            }
            return nums;
        }
    }
}
