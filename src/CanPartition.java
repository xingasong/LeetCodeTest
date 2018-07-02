public class CanPartition {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        sum = sum/2;
        boolean res[][] = new boolean[sum+1][nums.length+1];
        for(int i=0; i<res[0].length;i++){
            res[0][i] = true;
        }
        for(int i=1; i<=sum; i++){
            for(int j=1; j<=nums.length; j++){
                if(i-nums[j-1]>=0) res[i][j] = res[i][j-1]||res[i-nums[j-1]][j-1];
                else res[i][j] = res[i][j-1];
            }
        }
        return res[sum][nums.length];
    }

    public static void main(String[] args){
        int[] a = {1,5,11,5};
        System.out.println(canPartition(a));
    }
}
