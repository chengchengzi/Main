package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LC350 {
    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     */
    /*
        解法：O(nlog),O(1)
            1、先排序
            2、外排的方式统计并集的部分
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 0;
        while(a < nums1.length && b < nums2.length){
            if(nums1[a] == nums2[b]){
                list.add(nums1[a]);
                a++;
                b++;
            }else if(nums1[a] < nums2[b]){
                a++;
            }else{
                b++;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    /*
        解法2：O(N)/O(M),O(M+N)
        1、使用HashMap，key-value: nums1[i],次数
        2、统计key-value相同的
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i],1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
