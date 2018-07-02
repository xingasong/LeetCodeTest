public class FlowerBloomfirst {
    public static int flowerGroup(int[] flowers, int k) {
        if (k < 0 || k > flowers.length) return -1;
        if (k == 0) return -1;
        if (k == flowers.length) return k;
        int[] days = new int[flowers.length+2];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]] = i + 1;
        }
        days[0] = Integer.MAX_VALUE; // never bloom
        days[days.length-1] = Integer.MAX_VALUE; //never bloom

        int res = Integer.MAX_VALUE;
        int left = 0, right = k + 1;

        loop : while (right < days.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left + 1; i < right; i++) {
                if (days[i] > days[left] || days[i] > days[right]) {
                    left = i;
                    right = left + k + 1;
                    continue loop;
                }
                max = Math.max(max, days[i]);
            }

            res = Math.min(res, max);
            left = right;
            right = left + k + 1;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] flowers = {3,6,1,4,2,5};
        System.out.println(flowerGroup(flowers, 1));
        System.out.println(flowerGroup(flowers, 2));
        System.out.println(flowerGroup(flowers, 3));
        System.out.println(flowerGroup(flowers, 4));
        System.out.println(flowerGroup(flowers, 5));
        System.out.println(flowerGroup(flowers, 6));
        System.out.println(flowerGroup(flowers, 7));
        System.out.println(flowerGroup(flowers, 8));
    }
}
