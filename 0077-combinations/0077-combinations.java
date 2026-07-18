class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, n, k, new ArrayList<>(), ans, 0);
        return ans;
    }
    public void solve(int idx, int n, int k, List<Integer> curr, List<List<Integer>> ans, int cl){
        
        if(cl == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if( idx >= n + 1 ){
            return;
        }
        if(cl >= k) return;

        curr.add(idx);
        solve(idx + 1, n, k, curr, ans, cl + 1);
        curr.remove(curr.size() - 1);
        solve(idx + 1, n, k, curr, ans, cl);
    }
}