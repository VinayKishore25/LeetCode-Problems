class Solution {
    public void solve(List<List<Integer>> al , List<Integer> temp, int [] nums, int ind){
    if(temp.size() == nums.length)
    al.add(new ArrayList<>(temp));
    for(int i = 0; i < nums.length; i++){
        if(temp.contains(nums[i])) continue;
        temp.add(nums[i]);
        solve(al, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
    }
}
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();
    Arrays.sort(nums);
    solve(al, new ArrayList<>(), nums, 0);
    return al;
    }
}
