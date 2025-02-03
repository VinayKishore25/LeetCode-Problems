class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1 , dec = 1,ans = 1;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            inc = 1;
            dec = 1;
            for(int j = i+1 ; j < n ; j++)
            {
                // ans = Math.max(ans,Math.max(inc,dec));
                // System.out.println(inc + " " + dec);
                // System.out.println(ans);
                if(nums[j-1] > nums[j]) 
                {
                    inc++;
                    dec = 1;
                }
                else if(nums[j-1] < nums[j])
                {
                    dec++;
                    inc = 1;
                }
                else
                {
                    inc = 1;
                    dec = 1;
                }
                ans = Math.max(ans,Math.max(inc,dec));
            }
        }
        return ans;
    }
}