class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] freq = new int[100001];
        int j = 0;
        int n = nums.length;
        Arrays.fill(freq, -1);
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == x){
                freq[j++] = i;
            }
        }
        // System.out.println(Arrays.toString(freq));
        int q = queries.length;
        int[] ans = new int[q];
        for(int i = 0 ; i < q ; i++){
            ans[i] = freq[queries[i] - 1];
        }
        return ans;
    }
}