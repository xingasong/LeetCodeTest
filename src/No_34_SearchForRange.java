import java.util.Arrays;

public class No_34_SearchForRange {

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        int start = -1, end = -1;
        while(lo<=hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid]==target) {
                start = mid;
                hi = mid - 1;
            } else if(nums[mid]>target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        lo = 0; hi = len - 1;
        while (lo<=hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid]==target) {
                end = mid;
                lo = mid + 1;
            } else if(nums[mid]>target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int[] res = {start, end};
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,2,2,2,2,3,3,3,3,4,4};
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }

}
