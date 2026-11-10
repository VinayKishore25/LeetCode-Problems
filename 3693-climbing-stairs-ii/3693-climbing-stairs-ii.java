class Solution {
    public int climbStairs(int n, int[] costs) {
        int prev = 0, secondPrev = 0, thirdPrev = 0;
        for(int i = 1 ; i <= n ; i++){
            int curr = Integer.MAX_VALUE;
            curr = Math.min(curr, prev + costs[i - 1] + 1);
            if(i >= 2){
                curr = Math.min(curr, secondPrev + costs[i - 1] + 4);
            }
            if(i >= 3){
                curr = Math.min(curr, thirdPrev + costs[i - 1] + 9);
            }
            thirdPrev = secondPrev;
            secondPrev = prev;
            prev = curr;
        }
        return prev;
    }
}