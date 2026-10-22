class Solution {
    public int isRotatedArray(int[] nums, int n){
        int count = 1;
        boolean hasDecreasing = false;

        for(int i = 0 ; i < n - 1 ; i++){

            if(nums[i] < nums[i + 1] && !hasDecreasing){
                count++;
            }
            else if(hasDecreasing && nums[i] > nums[i + 1]){
                return -1;
            }
            else{
                hasDecreasing = true;
            }
        }

        if(nums[n - 1] > nums[0] && hasDecreasing){
            return -1;
        }

        return count;
    }
    public int isReverseRotatedArray(int[] nums, int n){
        int count = 1;
        boolean hasIncreasing = false;

        for(int i = 0 ; i < n - 1 ; i++){
            if(nums[i] > nums[i + 1] && !hasIncreasing){
                count++;
            }
            else if(hasIncreasing && nums[i] < nums[i + 1]){
                return -1;
            }
            else{
                hasIncreasing = true;
            }
        }

        if(nums[n - 1] < nums[0] && hasIncreasing){
            return -1;
        }

        return count;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = -1;
        
        int rotatedCount = isRotatedArray(nums, n);
        int reverseRotatedCount = isReverseRotatedArray(nums, n);

        if(rotatedCount == n){
            return 0;
        }
        if(rotatedCount != -1){
            // System.out.println(rotatedCount + "normal");
            ans = Math.min(rotatedCount , 2 + n - rotatedCount);
        }
        if(reverseRotatedCount != -1){
            // System.out.println(reverseRotatedCount + "reverse");
            ans = Math.min(reverseRotatedCount + 1 , 1 + n - reverseRotatedCount);
        }

        return ans;
    }
}