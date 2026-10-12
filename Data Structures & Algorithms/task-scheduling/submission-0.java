class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        for (int freq : map.values()) {
            pq.offer(freq);
        }
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int freq = pq.poll();
                freq--;

                if (freq > 0) {
                    q.offer(new int[]{freq, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
