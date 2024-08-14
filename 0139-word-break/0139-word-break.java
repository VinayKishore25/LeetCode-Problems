class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        int n = s.length();
        HashMap<String,Boolean> dp = new HashMap<>();
        return solve(s,hs,dp);
    }
    public boolean solve(String s,Set<String> hs,HashMap<String,Boolean> dp){
        if(hs.contains(s)) return true;
        if(dp.containsKey(s)) return dp.get(s);
        int n = s.length();
        boolean res = false;
        for(int i = 1 ; i < n ; i++){
            String temp = s.substring(0,i);
            if(hs.contains(temp) && solve(s.substring(i),hs,dp)){
                boolean ans = true;
                dp.put(temp,ans);
                return ans;
            }
        }
        dp.put(s,false);
        return false;
    }
}