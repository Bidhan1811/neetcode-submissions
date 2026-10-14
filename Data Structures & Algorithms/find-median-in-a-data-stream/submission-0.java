class MedianFinder {
    PriorityQueue<Integer> pqMax;
    PriorityQueue<Integer> pqMin;
    public MedianFinder() {
        pqMax = new PriorityQueue<>(Collections.reverseOrder());
        pqMin = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        if (pqMax.isEmpty() || num <= pqMax.peek()) {
            pqMax.add(num);
        } else {
            pqMin.add(num);
        }
        if (pqMax.size() > pqMin.size() + 1) {
            pqMin.add(pqMax.poll());
        } else if (pqMin.size() > pqMax.size() + 1) {
            pqMax.add(pqMin.poll());
        }
        
    }
    
    public double findMedian() {
        if(pqMax.size() == pqMin.size()) {
            return (pqMax.peek() + pqMin.peek()) / 2.0;
        }
        else if(pqMax.size() > pqMin.size()) return (double)pqMax.peek();
        else return (double)pqMin.peek();
    }
}
