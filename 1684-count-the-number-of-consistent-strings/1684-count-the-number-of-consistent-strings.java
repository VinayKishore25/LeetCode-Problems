class Solution {
    public boolean isValid(String s, HashSet<Character> hs){
        int n = s.length();
        for(int i = 0 ; i < n ; i++)
        {
            if(!hs.contains(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();
        
        for(char each : allowed.toCharArray())
        {
            hs.add(each);
        }
        int n = words.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(isValid(words[i],hs)){
                count++;
            }
        }
        return count;
    }
}