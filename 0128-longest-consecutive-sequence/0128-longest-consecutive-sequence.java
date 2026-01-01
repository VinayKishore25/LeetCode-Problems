class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int result = 1;
        int currentLength = 1;
        int prev = nums[0];
        for(int i = 1 ; i < n ; i++){
            if(nums[i] == prev) continue;
            if(prev + 1 == nums[i]){
                currentLength++;
            }
            else{
                result = Math.max(result,currentLength);
                currentLength = 1;
            }
            prev = nums[i];
        }
        result = Math.max(result,currentLength);
        return result;
    }
}