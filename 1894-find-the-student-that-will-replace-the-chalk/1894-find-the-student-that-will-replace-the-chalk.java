class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        Queue<Integer> q = new LinkedList<>();
        long total = 0;
        for(int i = 0 ; i < n ; i++){
            q.add(i);
            total+=chalk[i];
        }
        // if(k < total)
        k %= total;
        while(k >= chalk[q.peek()]){
            k -= chalk[q.peek()];
            int curr = q.poll();
            q.add(curr);
        }
        return q.peek();
    }
}