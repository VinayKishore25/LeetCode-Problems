class Solution {
    public boolean isPalin(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    public void solve(int i,List<List<String>> al,List<String> temp,String s,int n)
    {
        if(i >= n) 
        {
            al.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPalin(s.substring(i, j + 1))) {
                temp.add(s.substring(i, j + 1));
                solve(j+1,al,temp,s,n);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> al = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(0,al,temp,s,s.length());
        return al;
    }
}