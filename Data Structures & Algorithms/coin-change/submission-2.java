class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
    public int solve(int[] arr, int amt, int i) {
        if(amt == 0) return 0;
        int n = Integer.MAX_VALUE;
        for(int k = i; k < arr.length; k++) {
            if(amt - arr[k] < 0) continue;
            int next = solve(arr, amt-arr[k], k);
            if(next != Integer.MAX_VALUE) n = Math.min(n, 1 + next);
        }
        return n;
    }
}
