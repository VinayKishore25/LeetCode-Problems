class Solution {
    public int getDivisorSum(int n){
        int count = 2;
        int sum = 1 + n;
        for(int i = 2 ; i * i <= n; i++){
            if(n % i == 0 && i * i == n){
                count += 1;
                sum += i;
                continue;
            }
            if(n % i == 0){
                count+=2;
                sum += i;
                sum += n/i;
            }
        }
        if(count == 4){
            return sum;
        }
        return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < 6 ; i++){
            hm.put(i,0);
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 5 && !hm.containsKey(nums[i])){
                hm.put(nums[i],getDivisorSum(nums[i]));
            }
            sum += hm.get(nums[i]);
        }
        return sum;
    }
}