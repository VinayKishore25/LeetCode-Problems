class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        int n = pattern.length();
        String[] strArr = s.split(" ");
        int m = strArr.length;
        if(n != m) return false;
        for(int i = 0 ; i < n ; i++){
            if(hm.containsKey(pattern.charAt(i))){
                if(!hm.get(pattern.charAt(i)).equals(strArr[i])){
                    return false;
                }
            }
            else{
                if(hs.contains(strArr[i])) return false;
                hm.put(pattern.charAt(i),strArr[i]);
                hs.add(strArr[i]);
            }
        }
        return true;
    }
}