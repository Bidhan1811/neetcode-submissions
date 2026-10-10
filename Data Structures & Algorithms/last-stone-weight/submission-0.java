class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones) {
            pq.add(num);
        }
        int i = 0;
        while(i < stones.length && pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if(y < x || x < y) pq.add(Math.abs(x-y));
            i++;
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
