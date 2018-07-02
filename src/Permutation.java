import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> lists, List<Integer> tmpList, int[] nums) {
        if(tmpList.size() == nums.length) {
            lists.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i : nums){
            if(!tmpList.contains(i)){
                tmpList.add(i);
                backtrack(lists, tmpList, nums);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
