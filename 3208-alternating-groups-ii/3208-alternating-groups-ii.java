class Solution 
{
    public int numberOfAlternatingGroups(int[] c, int k) 
    {
        int start = 0, cnt = 0;
        boolean isEven = k % 2 == 0;
        int[] nums = Arrays.copyOf(c, (c.length + (k-1)));
        System.arraycopy(c, 0, nums, c.length, k-1);

        for(int end = 1; end < nums.length; end++)
        {
            if((end - start) < k-1)
            {
                if(nums[end] == nums[end-1]) start = end;
            }
            else 
            {
                if(isEven)
                {
                    if(nums[start++] != nums[end]) cnt++;
                    else start = end;
                }
                else 
                {
                    if(nums[start++] == nums[end]) cnt++;
                    else start = end;
                }
            }
        }
        return cnt;
    }
}