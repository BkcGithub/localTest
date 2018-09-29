package algorithm;

public class FindSecondMaxNum {

    public static int findSecond(int[] nums) {

        int maxNum = 0;
        int secMaxNum = 0;

        if (nums.length < 2) {
            return -1;
        }
        if (nums[0] > nums[1]) {
            maxNum = nums[0];
            secMaxNum = nums[1];
        } else {
            secMaxNum = nums[0];
            maxNum = nums[1];
        }

        for (int n = 2; n < nums.length; n++) {
            if (nums[n] > maxNum) {
                secMaxNum = maxNum;
                maxNum = nums[n];
            } else {
                if (nums[n] >= secMaxNum) {
                    secMaxNum = nums[n];
                }
            }
        }


        return secMaxNum;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,5,4,9,-1};

        System.out.println(findSecond(nums));
    }
}
