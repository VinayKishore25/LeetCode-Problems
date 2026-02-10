class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int n = s.length();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for(int i = 0 ; i < n ; i++){
            if(sc[i] != tc[i]){
                return false;
            }
        }
        return true;
    }
}