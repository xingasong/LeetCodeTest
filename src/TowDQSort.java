import java.util.*;

public class TowDQSort {
    /*public static void twoDQuickSort(int[][] nums, int p, int r){
        if(p<r){
            int x = nums[r][0];
            int x1 = nums[r][1];
            int i = p - 1;
            for(int j=p; j<r; j++){
                if(nums[j][0]>x){
                    i++;
                    int tmp = nums[i][0];
                    int tmp1 = nums[i][1];
                    nums[i][0] = nums[j][0];
                    nums[i][1] = nums[j][1];
                    nums[j][0] = tmp;
                    nums[j][1] = tmp1;
                }
            }
            nums[r][0] = nums[i+1][0];
            nums[r][1] = nums[i+1][1];
            nums[i+1][0] = x;
            nums[i+1][1] = x1;
            int q = i+1;
            twoDQuickSort(nums, p, q-1);
            twoDQuickSort(nums, q+1, r);
        }
        for(int i=1; i<nums.length; i++){
            if(nums[i][0]==nums[i-1][0]){
                if(nums[i-1][1]>nums[i][1]){
                    int tmp = nums[i][0];
                    int tmp1 = nums[i][1];
                    nums[i][0] = nums[i-1][0];
                    nums[i][1] = nums[i-1][1];
                    nums[i-1][0] = tmp;
                    nums[i-1][1] = tmp1;
                }
            }
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        twoDQuickSort(people, 0, people.length-1);
        List<int[]> res = new ArrayList<>();
        //int[] m = new int[2];
        //m[0] = people[0][0];
        //m[1] = people[0][1];
        //res.add(m);
        for(int i=0; i<people.length; i++){
            int[] tmp = new int[2];
            tmp[0] = people[i][0];
            tmp[1] = people[i][1];
            res.add(people[i][1], tmp);
        }
        int[][] res1 = new int[people.length][2];
        for(int i=0; i<people.length; i++){
            res1[i] = res.get(i);
        }
        return res1;
    }
    */
    /*
    private Comparator<int[]> ArrayComparator = new Comparator<>() {
        @Override
        public int compare(int[] p1, int[] p2) {
            if(p1[0] == p2[0]){
                return Integer.compare(p1[1], p2[1]);
            }
            return -Integer.compare(p1[0], p2[0]);
        }
    };
    */
    private int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<>() {
                @Override
                public int compare(int[] p1, int[] p2) {
                    if(p1[0] == p2[0]){
                        return p1[1] - p2[1];
                    }
                    return p2[0] - p1[0];
                }
            });

            ArrayList<int[]> result = new ArrayList<>();
            for(int[] p: people){
                result.add(p[1], p);
            }

            int[][] array = new int[people.length][2];
            for(int i = 0; i<people.length; i++){
                array[i] = result.get(i);
            }
            return array;
    }


    public static void main(String[] args){
        int[][] nums = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        TowDQSort test = new TowDQSort();
        System.out.println(Arrays.deepToString(test.reconstructQueue(nums)));
    }
}
