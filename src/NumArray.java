public class NumArray {
    private int[] nums1;
    public NumArray(int[] nums) {
        nums1 = new int[nums.length+1];
        int i = 0;
        for (int num :nums) {
            nums1[++i] = nums1[i-1] + num;
        }
    }

    public int sumRange(int i, int j) {
        if (i >= nums1.length-1 || j >= nums1.length-1) return 0;
        return nums1[j+1] - nums1[i];
    }
}