class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n != m){
            return false;
        }
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(char ch : s1.toCharArray()){
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }
        for(char ch : s2.toCharArray()){
            if(!hm1.containsKey(ch)) {
                return false;
            }
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!hm2.containsKey(s1.charAt(i))){
                return false;
            }
            if((hm1.get(s1.charAt(i)) != hm2.get(s1.charAt(i))) || (hm1.get(s2.charAt(i)) != hm2.get(s2.charAt(i)))){
                return false;
            }
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count == 2 || count == 0;
    }
}