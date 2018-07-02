public class No_152_MaximunProduct {
    public int maxProduct(int[] nums) {
        int maxEndHere = nums[0];
        int minEndHere = nums[0];
        int max = nums[0];
        for(int num : nums) {
            if(num>=0) {
                maxEndHere = Math.max(maxEndHere*num, num);
                minEndHere = Math.min(minEndHere*num, num);
            }
            else {
                int tmp = maxEndHere;
                maxEndHere = Math.max(minEndHere*num, num);
                minEndHere = Math.min(tmp*num, num);
            }
            max = Math.max(maxEndHere, max);
        }
        return max;
    }
}
