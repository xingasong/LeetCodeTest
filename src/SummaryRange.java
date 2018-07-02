import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i=0; i<nums.length; i++) {
            int flag = i;
            while (i != nums.length-1 && nums[i+1] == nums[i] + 1) {
                i++;
            }
            StringBuilder tmp = new StringBuilder();
            if (i != flag) {
                tmp.append(nums[flag]);
                tmp.append("->");
                tmp.append(nums[i]);
            } else tmp.append(nums[i]);
            res.add(tmp.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
