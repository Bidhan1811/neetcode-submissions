class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int ans = r;
        while(l <= r) {
            int mid = l + (r-l)/2;
            int hrs = 0;
            for(int i = 0; i < piles.length; i++) {
                 hrs += Math.ceil((double) piles[i] / mid);
            }
            if(hrs <= h) {
                ans = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}
