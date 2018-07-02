public class No_33 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len-1;
        while(lo<hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid]>nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rot = hi;
        lo = 0;
        hi = len-1;
        while(lo<=hi) {
            int mid = (lo + hi) / 2;
            int realMid = (mid + rot) % len;
            if(target==nums[realMid]) return realMid;
            else if(target>nums[realMid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

}
