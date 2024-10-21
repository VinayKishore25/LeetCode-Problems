class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] > 0)
            hs.add(nums[i]);
        }
        for(int i = 1 ; i <= n+1 ; i++)
        {
            if(!hs.contains(i))
            return i;
        }
        return 1;
    }
}