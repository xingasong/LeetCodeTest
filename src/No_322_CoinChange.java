public class No_322_CoinChange {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE-1;
        for(int coin : coins) {
            res = Math.min(res, coinChange(coins, amount-coin)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        No_322_CoinChange test = new No_322_CoinChange();
        int m = test.coinChange(coins, amount);
        m = (m==Integer.MAX_VALUE) ? -1 : m;
        System.out.println(m);
    }
}
