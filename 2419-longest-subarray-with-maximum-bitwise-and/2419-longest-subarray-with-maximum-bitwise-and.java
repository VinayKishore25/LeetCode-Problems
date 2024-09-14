class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int each : nums){
            max = Math.max(each,max);
        }
        int count = 0,ans = 0,n = nums.length;
        int i = 0;
        while(i < n){
            if(nums[i] == max){
                while(i < n && nums[i++] == max){
                    count++;
                }
                ans = Math.max(ans,count);
                count = 0;
            }
            else
            i++;
        }
        return ans;
    }
}