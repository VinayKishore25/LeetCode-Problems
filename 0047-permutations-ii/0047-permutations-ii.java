class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,nums,n,ans);
        return ans;
    }
    public void solve(int idx, int[] nums, int n, List<List<Integer>> ans){
        if(idx == n){
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = idx ; i < n ; i++){

            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            swap(nums,i,idx);
            solve(idx + 1,nums,n,ans);
            swap(nums,i,idx);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}