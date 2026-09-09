class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] arr = new int[26];
        for(int b = 0; b < n; b++) {
            arr[s1.charAt(b) - 'a']++;
        }
        int[] s = new int[26];
        for(int k = 0; k < n && k < s2.length(); k++) {
            s[s2.charAt(k)-'a']++;
        }
        if(Arrays.equals(arr, s)) return true;
        for(int i = n; i < m; i++) {
            s[s2.charAt(i) - 'a']++;
            s[s2.charAt(i-n)-'a']--;
            if(Arrays.equals(arr, s)) return true;
        }
        return false;
    }
}
