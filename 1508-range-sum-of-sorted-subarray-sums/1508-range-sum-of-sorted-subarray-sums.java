class Solution {
    public void solve(int[] nums,int i, int sum,ArrayList<Integer> al,int n,ArrayList<Integer> temp){
        if(i >= n)
        {
            return;
        }
        // temp.add(nums[i]);
        sum+=nums[i];
        al.add(sum);
        // System.out.println(temp);
        solve(nums,i+1,sum,al,n,temp);
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            solve(nums,i,0,al,n,temp);
        }
        Collections.sort(al);
        // System.out.println(al);
        int ans = 0;
        int mod = 10000_00007;
        for(int i =  left - 1 ; i < right ; i++)
        {
            ans = (ans + al.get(i))%mod;
        }
        return ans%mod;
    }
}