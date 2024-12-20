class Solution {
    public int binarySearch(int[] nums,int target,int n){
        int low = 0;
        int high = n - 1;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int ind = binarySearch(nums,target,n);
        int lower = ind;
        int upper = ind;
        while(lower > 0 && nums[lower - 1] == target){
            lower--;
        }
        while(upper < n - 1 && nums[upper + 1] == target){
            upper++;
        }
        int[] res = {lower,upper};
        return res;
    }
}