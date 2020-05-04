package leetcode;

public class LC75 {
    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * 示例:
     *
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * 进阶：
     *
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     */
    /*
        解法1：O(N)，O(1)
        思路：
            分别统计0，1，2的个数，重建数组
     */
    public void sortColors(int[] nums) {
        if(nums.length == 0){
            return ;
        }
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                cnt0++;
            }else if(nums[i] == 1){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        int index = 0;
        for(int i = 0; i < cnt0; i++){
            nums[index++] = 0;
        }
        for(int i = 0; i < cnt1; i++){
            nums[index++] = 1;
        }
        for(int i = 0; i < cnt2; i++){
            nums[index++] = 2;
        }
    }

    /*
        解法2：O(N),O(1)
        思路：
            使用荷兰国旗问题解法
     */
    public void sortColors2(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int p0 = -1;
        int cur = 0;
        int p2 = nums.length;
        while (cur < p2) {
            if (nums[cur] == 0) { //遇到0，与p0的下一位置交换
                int tmp = nums[p0 + 1];
                nums[p0 + 1] = nums[cur];
                nums[cur] = tmp;
                p0++;
                cur++;
            } else if (nums[cur] == 2) { //遇到2，与p2的前一位置交换
                int tmp = nums[p2 - 1];
                nums[p2 - 1] = nums[cur];
                nums[cur] = tmp;
                p2--;
            }else{
                cur++;
            }
        }
    }
}
