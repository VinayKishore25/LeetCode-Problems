class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1)return 1;
        if(trust.length==0)return -1;
        if(trust.length == 1) return trust[0][1];
        int ans = trust[0][1];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < trust.length ; i++)
        {
            hm.put(trust[i][0],-1);
            if(!hm.containsKey(trust[i][1]))
            hm.put(trust[i][1],1);
            else
            {
                if(hm.get(trust[i][1])!=-1)
                hm.put(trust[i][1],hm.getOrDefault(trust[i][1],0)+1);
            }
        }
        System.out.println(hm);
        HashSet<Integer> hs = new HashSet<>();
        int max = 0;
        for(int each : hm.values())
        {
            if(each != -1){
                if(each > max)
                {
                    max = each;
                }
            }
        }
        int v = -1;
        if(hs.size()==1)
        return -1;
        for(int i = 0 ; i < trust.length ; i++)
        {
            if(hm.get(trust[i][1])==max && max == n-1)
            {
                v =trust[i][1];
                break;
            }
        }
        return v;
    }
}