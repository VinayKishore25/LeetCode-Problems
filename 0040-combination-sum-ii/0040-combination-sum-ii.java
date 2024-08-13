class Solution {
    public void solve(int[] candidates,int target,List<List<Integer>> res,List<Integer> al,int i,int n,int sum)
    {
        if(sum == target) {
            Collections.sort(al);
            if(!res.contains(al))
            res.add(new ArrayList<>(al));
            return;
        }
        if(sum > target || i == n) return;
        al.add(candidates[i]);
        solve(candidates,target,res,al,i+1,n,sum+candidates[i]);
        al.remove(al.size() - 1);
        int j = i + 1;
        while(j < n && candidates[j] == candidates[i]){
            j++;
        }
        solve(candidates,target,res,al,j,n,sum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(candidates,target,res,temp,0,n,0);
        return res;
    }
}