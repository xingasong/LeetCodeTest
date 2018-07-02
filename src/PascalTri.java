import java.util.ArrayList;
import java.util.List;

public class PascalTri {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) return res;
        res.add(new ArrayList<Integer>(1));
        for (int i = 1; i<numRows; i++) {
            res.add(new ArrayList<Integer>(1));
            for(int j = 1; j < i; j++) {
                res.get(i).add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.get(i).add(1);
            System.out.println(res.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
