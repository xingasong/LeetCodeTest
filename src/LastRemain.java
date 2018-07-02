import java.util.LinkedList;

public class LastRemain {
    public static int lastRemaininga(int n) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        boolean fromLeft = true;
        while (res.size() != 1) {
            if (fromLeft) {
                int i = 0;
                while (i < res.size()) {
                    if (res.size() == 1) return res.get(0);
                    res.remove(i);
                    i++;
                }
                fromLeft = false;
            } else {
                int i = res.size()-1;
                while (i >= 0) {
                    if (res.size() == 1) return res.get(0);
                    res.remove(i);
                    i -= 2;
                }
                fromLeft = true;
            }
        }
        return res.get(0);
    }

    public static int lastRemainingb(int n) {
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean left = true;
        while (remaining > 1) {
            if (left || remaining%2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaininga(4011));
        System.out.println(lastRemainingb(4011));
    }
}
