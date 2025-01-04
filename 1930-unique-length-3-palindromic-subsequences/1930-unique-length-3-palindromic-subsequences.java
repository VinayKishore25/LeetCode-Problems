class Solution {
    public int getDistinctChars(String s,int f,int l){
        HashSet<Character> hs = new HashSet<>();
        for(int i = f + 1; i < l ; i++){
            hs.add(s.charAt(i));
        }
        return hs.size();
    }
    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        int n = s.length();
         for (int i = 0; i < 26; i++) {
            lastIndex[i] = -1;
            firstIndex[i] = n;
        }
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            firstIndex[ch - 'a'] = Math.min(firstIndex[ch - 'a'],i);
            lastIndex[ch - 'a'] = Math.max(lastIndex[ch - 'a'],i);
        }
        int result = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(firstIndex[i] < lastIndex[i]){
                // System.out.println(getDistinctChars(s,firstIndex[i],lastIndex[i]));
                result += getDistinctChars(s,firstIndex[i],lastIndex[i]);
            }
        }
        return result;
    }
}