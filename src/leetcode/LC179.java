package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC179 {
    /**
     * 179. 最大数
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: 210
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */

    /*
        解法：
        思路：
            1、本质上还是排序，X，Y-> XY > YX ? X > Y : Y > X
     */
    public String largestNumber(int[] nums) {
        if(nums.length == 0){
            return "";
        }
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
       // Arrays.sort(strs,(x,y)->(y + x).compareTo(x + y));
        Arrays.sort(strs,new NewComparator());
        //排序之后，最大值为0，则直接返回0
        if(strs[0].equals("0")){
            return "0";
        }

        String res = "";
        for(int i = 0; i < strs.length; i++){
            res += strs[i];
        }
        return res;
    }
    private class NewComparator implements Comparator<String> {
        @Override
        public int compare(String x,String y) {
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy);
        }
    }
}
