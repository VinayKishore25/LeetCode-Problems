class Solution {
    public int jump(int[] nums) {        
        int farMove = 0;
        int end = 0;
        int jumps = 0;
        int n = nums.length;
        if(n == 1) return 0;
        for(int i = 0 ; i < n ; i++){
            farMove = Math.max(farMove,i+nums[i]);
            if(i == end){
                end = farMove;
                jumps++;
                if(farMove >= n - 1){
                    return jumps;
                }
            }
        }
        return -1;
    }
}