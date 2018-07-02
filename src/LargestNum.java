import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {


    public static void main(String[] args) {
        int[] nums = {32,12,56,34,2,5,7,8};
        String[] snums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            snums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(snums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        System.out.println(Arrays.toString(snums));
    }

}
