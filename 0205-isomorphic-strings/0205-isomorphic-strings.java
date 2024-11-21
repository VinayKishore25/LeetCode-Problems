class Solution {
    public boolean isIsomorphic(String str1, String str2) {
        if(str1.length() != str2.length())
        return false;
        HashMap<Character,Character> hm=new HashMap<>();
        HashMap<Character,Character> hm1=new HashMap<>();
        int a = str1.length() , b = str2.length();
        for(int i = 0 ; i < a ; i++)
        {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(hm.containsKey(c1))
            {
                if(hm.get(c1) != c2)
                return false;
            }
            else
            hm.put(c1,c2);
            if(hm1.containsKey(c2))
            {
                if(hm1.get(c2) != c1)
                {
                    return false;
                }
            }
            else
            hm1.put(c2,c1);
        }
        return true;
    }
}