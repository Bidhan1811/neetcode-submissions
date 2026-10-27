class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordList) {
            set.add(word);
        }
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int cnt = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if(word.equals(endWord)) return cnt;
                char[] arr = word.toCharArray();
                for(int j = 0; j < word.length(); j++) {
                    char orig = arr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == orig) continue;
                        arr[j] = ch;
                        String next = new String(arr);
                        if(set.contains(next)) {
                            set.remove(next);
                            q.add(next);
                        }
                    }
                    arr[j] = orig;
                }
            }
            cnt++;
        }
        return 0;
    }
}
