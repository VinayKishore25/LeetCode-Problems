class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums.length==1) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int each : nums)
        {
            pq.add((long)each);
        }
        int res = 0;
        while(pq.size() > 1 && pq.peek() < k)
        {
            res++;
            long a = pq.poll();
            long b = pq.poll();
            long ad = Math.min(a,b)*2 + Math.max(a,b);
            pq.add(ad);
        }
        return res;
    }
}