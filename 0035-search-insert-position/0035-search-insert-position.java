class Solution {
    public int searchInsert(int[] nums, int target) {
        int ind = Arrays.binarySearch(nums,target);
        if(ind < 0)
        return Math.abs(ind) - 1;
        return ind;
    }
}