import JZOffer.JZ59I;
import LeetCode.LC242;

public class Main {
    public static int cntBits(int num){
        int res = 0;
        while (num != 0){
            num = num & (num - 1);
            res += 1;
        }
        return res;
    }

    public static int[] newSort(int[] nums) {
        Integer[] numsSorted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsSorted[i] = nums[i];
        }
        Arrays.sort(numsSorted, (num1,num2) -> cntBits(num1) == cntBits(num2) ? num1 - num2 : cntBits(num1) - cntBits(num2));
        int[] res = new int[numsSorted.length];
        int index = 0;
        for(Integer num : numsSorted){
            res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = new LC350().intersect2(nums1,nums2);
        for(int i : res){
            System.out.println(i);
        }
    }
}

