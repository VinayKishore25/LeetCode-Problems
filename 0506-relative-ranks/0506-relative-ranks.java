class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int n = score.length;
        String[] ans = new String[n];
        for(int i = 0 ; i < n ; i++)
        {
            tm.put(score[i],i);
        }
        int count = n;
        String res;
        for(int each : tm.keySet())
        {
            if(count == 1)
            {
                res = "Gold Medal";
            }
            else if(count == 2)
            {
                res = "Silver Medal";
            }
            else if(count == 3)
            {
                res = "Bronze Medal";
            }
            else
            {
                res = "" + count;
            }
            ans[tm.get(each)] = res;
            count--;
        }
        return ans;
    }
}