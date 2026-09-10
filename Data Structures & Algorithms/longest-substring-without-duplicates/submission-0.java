class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = Integer.MIN_VALUE;
        while(i <= j && j < s.length()) {
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                len = Math.max(len, j - i + 1);
                j++;
            }
            else {
                while(map.containsKey(s.charAt(j))) {
                    map.remove(s.charAt(i));
                    i++;
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }
}
