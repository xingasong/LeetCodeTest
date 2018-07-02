import java.util.*;

public class Test {


    private int findKth(int[] nums, int lo, int hi, int k) {
        int i = lo, j = hi - 1, pivot = nums[hi];
        while (i <= j) {
            if (nums[i] > pivot) {
                swap(nums, i, j);
                j--;
            } else i++;
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) return nums[i];
        if (m > k) return findKth(nums, lo, i - 1, k);
        else return findKth(nums, i + 1, hi, k - m);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    //Test

    public static void main(String[] args) {
        Test a = new Test();
        int[] nums = {4,2,6,7,10,8};
        System.out.println(a.findKth(nums, 0, 4, 3));
    }
}