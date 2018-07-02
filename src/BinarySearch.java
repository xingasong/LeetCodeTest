public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,10,12,15,23,34,41,56,73};
        System.out.println(binarySearch(nums, 24));
    }
}
