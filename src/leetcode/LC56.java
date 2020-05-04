package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC56 {
    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

    /*
        解法：
        思路：
            1、将所有数据对按左值进行排序
            2、将排序后的第一对数据放入resList中，依次遍历之后的数据对，在resList中更新合并区间，更新规则：
                -》如果当前数据对的左值 《= resList中最后一对数据对的右值，有重合区域，更新resList中右值为二者较大的右值
                -》否则，无重合区域，直接添加进resList

     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        ArrayList<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= resList.get(resList.size() - 1)[1]){
                resList.get(resList.size() - 1)[1] = Math.max(intervals[i][1],resList.get(resList
                .size() - 1)[1]);
            }else{
                resList.add(intervals[i]);
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
