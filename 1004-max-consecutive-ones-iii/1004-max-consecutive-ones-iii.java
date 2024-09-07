class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0 , first = 0 , second = 0,ans = 0;
        while(second < nums.length)
        {
            if(nums[second]==0)
            zeroCount++;
            if(zeroCount>k)
            {
                if(nums[first]==0)
                zeroCount--;
                first++;
            }
            ans = Math.max(ans,second-first+1);
            second++;
        }
        return ans;
    }
}