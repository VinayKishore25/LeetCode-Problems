class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zeroes1 = 0, zeroes2 = 0, sum1 = 0, sum2 = 0;
        int n = nums1.length;
        for(int i = 0 ; i < n ; i++){
            if(nums1[i] == 0){
                zeroes1++;
            }
            sum1 += nums1[i];
        }
        int m = nums2.length;
        for(int i = 0 ; i < m ; i++){
            if(nums2[i] == 0){
                zeroes2++;
            }
            sum2 += nums2[i];
        }
        if(zeroes1 == 0 && zeroes2 == 0){
            if(sum1  != sum2 ){
                return -1;
            }
            return sum1 ;
        }
        if(zeroes2 == 0){
            if(sum2 <= sum1 || (sum2 - sum1)/zeroes1 <= 0){
                return -1;
            }
            else{
                return Math.max(sum1 + zeroes1 , sum2);
            }
        }
        if(zeroes1 == 0){
            if(sum1 <= sum2 || (sum1 - sum2)/zeroes2 <= 0){
                return -1;
            }
            else{
                return Math.max(sum2 + zeroes2 , sum1);
            }
        }
        return Math.max(sum1 + zeroes1 , sum2 + zeroes2);
    }
}