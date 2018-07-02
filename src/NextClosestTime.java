import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextClosestTime {
    public static String nextClosestTime(String time) {
       char[] digits = new char[4];
       digits[0] = time.charAt(0);
       digits[1] = time.charAt(1);
       digits[2] = time.charAt(3);
       digits[3] = time.charAt(4);
       List<String> times = new ArrayList<>();
       for (int i = 0; i < 4; ++i) {
           if (digits[i] > '2') continue;
           for (int j = 0; j < 4; ++j) {
               if (j == i) continue;
               if (digits[i] == '2' && digits[j] > '3') continue;
               for (int k = 0; k < 4; k++) {
                   if (k == i || k == j) continue;
                   if (digits[k] > '5') continue;
                   for (int l = 0; l < 4; l++) {
                       if (l == i || l == j || l == k) continue;
                       times.add("" + digits[i] + digits[j] + ":" + digits[k] + digits[l]);
                   }
               }
           }
       }
       Collections.sort(times);
       System.out.println(times);
       int index = times.lastIndexOf(time);
       return index == times.size()-1 ? times.get(0) : times.get(index + 1);
    }

    public static void main(String[] args) {
        System.out.println(nextClosestTime("12:32"));
    }
}
