class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalBinaryCodes = (int)Math.pow(2,k);
        int n = s.length();
        if(n < k){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
        for(int i = 0 ; i < k ; i++){
            sb.append(s.charAt(i));
        }
        if(sb.length() == k){
            hs.add(sb.toString());
        }
        for(int i = k ; i < n ; i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            hs.add(sb.toString());
        }
        return hs.size() == totalBinaryCodes;
    }
}