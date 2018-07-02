import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QuickSort {
    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = nums[start + (end - start) / 2];
        int lo = start, hi = end;
        while (lo <= hi) {
            while (lo <= hi && nums[lo] < pivot) lo++;
            while (lo <= hi && nums[hi] > pivot) hi--;
            if (lo <= hi) {
                int tmp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = tmp;
                lo++;
                hi--;
            }
        }
        quickSort(nums, start, hi);
        quickSort(nums, lo, end);
    }

    public static void main(String[] args){
        Deque<Integer> queue = new LinkedList<>();
    }
}
