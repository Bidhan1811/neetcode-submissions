class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] arr = new int[26];
        int i = 0, j = n-1;
        for(int b = 0; b < n; b++) {
            arr[s1.charAt(b) - 'a']++;
        }
        while(i <= j && j < m) {
            String temp = s2.substring(i, j+1);
            int[] s = new int[26];
            for(int k = 0; k < temp.length(); k++) {
                s[temp.charAt(k)-'a']++;
            }
            if(Arrays.equals(arr, s)) return true;
            i++;
            j++;
        }
        return false;
    }
}
