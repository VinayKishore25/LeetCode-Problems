class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            freq[((nums[i] % value) + value) % value]++;

        }
        int res = 0;
        while(freq[res % value]--> 0) res++;
        return res;
    }
}