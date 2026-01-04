class Solution {
    public void solve(int i,int[] nums,List<Integer> temp,List<List<Integer>> al,int n)
    {
        if(i >= n)
        {
            al.add(new ArrayList<>(temp));
            return;
        }
        solve(i+1,nums,temp,al,n);
        temp.add(nums[i]);
        solve(i+1,nums,temp,al,n);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> al = new ArrayList<>();
        solve(0,nums,temp,al,nums.length);
        return al;
    }
}