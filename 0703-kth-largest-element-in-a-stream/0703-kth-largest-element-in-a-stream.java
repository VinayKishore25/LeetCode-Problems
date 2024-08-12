class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int max;
    public KthLargest(int k, int[] nums) {
        for(int each : nums){
            pq.add(each);
        }        
        while(pq.size() > k) pq.poll();
        max = k;
        // return pq.peek();
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > max) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */