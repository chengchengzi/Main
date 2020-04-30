package Sort;

import java.util.ArrayList;

public class FullSort {
    /**
     *
     * @param arr ：用于存储待排列的元素
     * @param n ：arr的下标，从0开始，一次与后面的元素交换
     * @param list ：保存全排列后的元素
     */
    public void fullSortCore(int[] arr, int n, ArrayList<int[]> list) {
        if (n >= arr.length - 1) { //完成一次全排列
            int [] arrTmp = new int[arr.length];
           for(int i = 0; i < arr.length; i++){
               arrTmp[i] = arr[i];
           }
           list.add(arrTmp);
        } else {
            for (int i = n; i < arr.length; i++) { //回溯法
                //交换
                int tmp = arr[n];
                arr[n] = arr[i];
                arr[i] = tmp;
                //递归
                fullSortCore(arr, n + 1,list);
                //恢复
                int tmp2 = arr[n];
                arr[n] = arr[i];
                arr[i] = tmp2;
            }

        }
    }

}
