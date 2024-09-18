class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] temp = new String[n];
        for(int i = 0 ; i < n ; i++){
            temp[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));
        String res = "";
        for(String each : temp){
            res += each;
        }
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}