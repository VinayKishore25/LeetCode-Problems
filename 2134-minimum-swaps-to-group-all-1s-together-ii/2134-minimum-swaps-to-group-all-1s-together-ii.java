class Solution {
    public int minSwaps(int[] nums) {
        int oneCount = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] == 1)
            oneCount++;
        }
        int[] prefix = new int[n + oneCount];
        prefix[0] = nums[0];
        int[] temp = new int[n + oneCount];
        for(int i = 0 ; i < n + oneCount; i++)
        {
            temp[i] = nums[i%n];
            if(i > 0)
            {
                prefix[i] = prefix[i-1] + nums[i%n];
            }
        }
        // System.out.println(Arrays.toString(prefix) +" " + oneCount);
        if(oneCount == n || oneCount == 0)
        {
            return 0;
        }
        int ans =oneCount - prefix[oneCount-1];
        int j = 0;
        for(int i = oneCount ; i < n + oneCount ; i++)
        {
            ans = Math.min(ans,oneCount - (prefix[i] - prefix[j]));
            j++;
            // System.out.println(ans);
        }
        return ans;
    }
}