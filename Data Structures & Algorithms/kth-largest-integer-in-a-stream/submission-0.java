class KthLargest {
    PriorityQueue<Integer> pq;
    int a;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        a = k;
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > a) {
            pq.poll();
        }
        return pq.peek();
    }
}
