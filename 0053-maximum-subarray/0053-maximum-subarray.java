class Solution {
    public int maxSubArray(int[] nums) {
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            count+=nums[i];
            maxi=Math.max(maxi,count);
            if(count < 0)
            {
                count = 0;
            }
        }
        return maxi;
    }
}