class Solution {
    public String res(String ans)
    {
        char[] ch = ans.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> al = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++)
        {
            String samp = res(strs[i]);
            if(!hm.containsKey(samp))
            {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                hm.put(samp,l);
            }
            else
            {
                List<String> l = hm.get(samp);
                l.add(strs[i]);
                hm.put(samp,l);
            }
        }
        for(List<String> each : hm.values())
        {
            al.add(each);
        }
        return al;
    }
}