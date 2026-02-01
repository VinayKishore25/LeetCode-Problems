class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        int[] res = new int[nums.length-1];
        for(int i = 0 ; i < nums.length -1 ; i++)
        {
            res[i] = nums[i+1];
        }
        Arrays.sort(res);
        ans += res[0];
        ans+= res[1];
        return ans;
    }
}