public class No_31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i;
                break;
            }
        }
        int lo = index, hi = len - 1;
        //reverse
        while(lo<hi) {
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
        if(index!=0) {
            //exchange index-1 to appropriate position
            for(int i=index; i<len; i++) {
                if(nums[i]>nums[index-1]) {
                    int tmp = nums[i];
                    nums[i] = nums[index-1];
                    nums[index-1] = tmp;
                    break;
                }
            }
        }
    }
}
