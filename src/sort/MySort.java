package sort;

import java.util.ArrayList;

public class MySort {
    /**
     *全排序
     * @param arr ：用于存储待排列的元素
     * @param n ：arr的下标，从0开始，一次与后面的元素交换
     * @param list ：保存全排列后的元素
     */
    public void fullSortCore(int[] arr, int n, ArrayList<int[]> list) {
        if (n >= arr.length - 1) { //递归出口，完成一次全排列
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

    /**
     * 归并排序
     * 步骤：
     *      1、找出中点
     *      2、递归对左边归并排序，递归对右半边归并排序
     *      3、对排序后的左右两边合并
     * @param nums
     */
    public void mergeSort(int[] nums,int begin, int end){
        if(begin == end){
            return ;
        }
        int mid = begin + (end - begin) / 2;
        mergeSort(nums,begin,mid);
        mergeSort(nums,mid + 1,end);
        merge(nums,begin,mid,end);
    }
    public void merge(int[] nums,int begin,int mid,int end){
        int[] tmp = new int[end - begin + 1];
        int p1 = begin;
        int p2 = mid + 1;
        int index = 0;
        while(p1 <= mid && p2 <= end){
            tmp[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= mid){
            tmp[index++] = nums[p1++];
        }
        while(p2 <= end){
            tmp[index++] = nums[p2++];
        }
        for(int i = 0; i < tmp.length;i++){
            nums[begin + i] = tmp[i];
        }
    }
}
