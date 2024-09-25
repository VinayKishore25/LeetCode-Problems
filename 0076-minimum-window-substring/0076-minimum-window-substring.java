class Solution {
    public String minWindow(String s, String p) {
        HashMap<Character,Integer> hm2 = new HashMap<>();
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(char ch : p.toCharArray()){
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        }
        int req = p.length();
        int n = s.length();
        int small = Integer.MAX_VALUE,up = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE,j = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(hm2.containsKey(ch)){
                if(hm1.getOrDefault(ch,0) < hm2.get(ch)){
                    req--;
                }
            }
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
            while(req == 0){
                char ch1 = s.charAt(j);
                if((i - j < res)){
                    small = j;
                    up = i;
                    res = i - j;
                }
                hm1.put(ch1,hm1.get(ch1) - 1);
                if(hm2.containsKey(ch1) && hm1.get(ch1) < hm2.get(ch1)){
                    req++;
                }
                j++;
            }
        }
        if(small == Integer.MAX_VALUE || up == Integer.MAX_VALUE) return "";
        return s.substring(small,up+1);
    }
}