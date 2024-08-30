class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 10000_00007;
        List<List<Integer>> f = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int j = i + 1 ;
            while(j < nums.length)
            {
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l)
                {
                    List<Integer> x = new ArrayList<>();
                    int ans = ((nums[i] + nums[j])%mod + (nums[k] + nums[l])%mod)%mod;
                    if(ans == target)
                    {
                        x.add(nums[i]);
                        x.add(nums[j]);
                        x.add(nums[k]);
                        x.add(nums[l]);
                        k++;
                        l--;
                        // Collections.sort(x);
                        f.add(x);
                    }
                    else if(ans > target)
                    l--;
                    else
                    k++;
                }
                j++;
            }
        }
        List<List<Integer>> al1 = new ArrayList<>();
        for(List<Integer> each : f)
        {
            if(!al1.contains(each))
            al1.add(each);
        }
        return al1;
    }
}