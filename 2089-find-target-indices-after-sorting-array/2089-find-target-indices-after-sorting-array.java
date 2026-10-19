class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int targetCount = 0 , lessThan = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == target){
                targetCount++;
            }
            else if(nums[i] < target){
                lessThan++;
            }
        }

        for(int i = 0 ; i < targetCount ; i++){
            ans.add(lessThan + i);
        }
        return ans;
    }
}