import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;
        int i = 0, j = 0;
        while(res.size() != len) {
            while (j != col-1 && matrix[i][j+1] != 2018) {
                res.add(matrix[i][j]);
                matrix[i][j] = 2018;
                j++;
            }
            while (i != row-1 && matrix[i+1][j] != 2018) {
                res.add(matrix[i][j]);
                matrix[i][j] = 2018;
                i++;
            }
            while (j != 0 && matrix[i][j-1] != 2018) {
                res.add(matrix[i][j]);
                matrix[i][j] = 2018;
                j--;
            }
            while (i != 0) {
                res.add(matrix[i][j]);
                matrix[i][j] = 2018;
                if (matrix[i-1][j] == 2018) {
                    j++;
                    break;
                }
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
        System.out.println(spiralOrder(matrix));
    }
}
