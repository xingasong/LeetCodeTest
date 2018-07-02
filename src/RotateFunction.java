public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            B[i] = i;
        }
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += A[j]*B[j];
            }
            max = Math.max(max, sum);
            for(int k=0; k<n; k++){
                B[k] += 1;
                if(B[k]==n) B[k] = 0;
            }
        }
        return max;
    }
}
