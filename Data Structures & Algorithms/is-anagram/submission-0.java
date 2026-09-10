class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            if(!map2.containsKey(c) || map2.get(c) != freq) return false;
        }
        return true;
    }
}
