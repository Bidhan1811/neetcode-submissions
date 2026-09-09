class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, res = 0, maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            int ind = s.charAt(right) - 'A';
            freq[ind]++;
            maxFreq = Math.max(freq[ind], maxFreq);
            int len = right - l + 1;
            int rep = len - maxFreq;
            while(rep > k) {
                freq[s.charAt(l)-'A']--;
                l++;
                len = right - l + 1;
                rep = len - maxFreq;
            }
            res = Math.max(res, right-l+1);
        }
        return res;
    }
}
