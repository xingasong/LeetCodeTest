import java.util.Arrays;

public class ShortestUnsorted {
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        int lo = 0, hi = nums.length-1;
        while(lo<hi&&(nums[lo]==tmp[lo]||nums[hi]==tmp[hi])){
            if(nums[lo]==tmp[lo]) lo++;
            if(nums[hi]==tmp[hi]) hi--;
        }
        return hi-lo+1;
    }
}
