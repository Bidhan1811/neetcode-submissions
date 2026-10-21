class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve(digits, map, ans, new StringBuilder(), 0);
        return ans;
    }
    public void solve(String digits, HashMap<Character, String> map, List<String> ans, StringBuilder temp, int i) {
        if(i == digits.length()) {
            ans.add(temp.toString());
            return;
        }
        String letters = map.get(digits.charAt(i));
        for(int j = 0; j < letters.length(); j++) {
            temp.append(letters.charAt(j));
            solve(digits, map, ans, temp, i+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
