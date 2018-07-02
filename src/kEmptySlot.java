public class kEmptySlot {
    public static int kEmptySlots(int[] flowers, int k) {
        if (k < 0 || k >flowers.length) return -1;
        if (k == 0) return flowers.length;
        if (k == flowers.length) return -1;
        int[] days = new int[flowers.length + 2];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]] = i + 1;
        }
        days[0] = Integer.MIN_VALUE;
        days[days.length-1] = Integer.MIN_VALUE;

        int left = 0, right = k + 1;
        int res = Integer.MAX_VALUE;
        loop : while (right < days.length) {
            for (int i = left + 1; i < right; i++) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    continue loop;
                }
            }

            res = Math.min(res, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] flowers = {4,6,3,7,2,8,1,5};
        System.out.println(kEmptySlots(flowers, 1));
        System.out.println(kEmptySlots(flowers, 2));
        System.out.println(kEmptySlots(flowers, 3));
        System.out.println(kEmptySlots(flowers, 4));
        System.out.println(kEmptySlots(flowers, 5));
        System.out.println(kEmptySlots(flowers, 6));
        System.out.println(kEmptySlots(flowers, 7));
        System.out.println(kEmptySlots(flowers, 8));
    }
}
