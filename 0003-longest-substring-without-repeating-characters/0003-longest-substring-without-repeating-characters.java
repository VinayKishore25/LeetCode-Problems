class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int i = 0 , j = 0;
        // HashMap<Character,Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        while(j < n){
            while(i < n && hs.contains(s.charAt(j))){
                hs.remove(s.charAt(i));
                i++;
                ans = Math.max(ans,j - i + 1);
            }
            hs.add(s.charAt(j));
            j++;
        }
        ans = Math.max(ans,j - i);
        return ans;
    }
}