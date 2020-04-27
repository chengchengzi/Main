import JZOffer.JZ59I;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new JZ59I().maxSlidingWindow2(nums,k);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]);
        }
    }
}
