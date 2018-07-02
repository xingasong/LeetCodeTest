import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthOfChain {

    public static int findLongestChain(int[][] pairs) {
        //QuickSort(pairs, 0, pairs.length-1);
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int count = 1;
        int flag = pairs[0][1];
        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0]>flag){
                count++;
                flag = pairs[i][1];
            }
        }
        return count;
    }

    /*private static void QuickSort(int[][] array,int start,int end)
    {
        if(start<end)
        {
            int key=array[start][1];
            int key0 = array[start][0];//初始化保存基元
            int i=start,j;//初始化i,j
            for(j=start+1;j<=end;j++)
            {
                if(array[j][1]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp=array[j][1];
                    int temp0 = array[j][0];
                    array[j][1]=array[i+1][1];
                    array[j][0]=array[i+1][0];
                    array[i+1][1]=temp;
                    array[i+1][0]=temp0;
                    i++;
                }

            }
            array[start][1]=array[i][1];
            array[start][0]=array[i][0];//交换i处元素和基元
            array[i][1]=key;
            array[i][0]=key0;
            QuickSort(array, start, i-1);//递归调用
            QuickSort(array, i+1, end);

        }

    }*/

    public static void main(String[] args){
        int[][] a = {{1,2},{6,8},{4,5},{1,6}};
        System.out.println(findLongestChain(a));
    }

}
