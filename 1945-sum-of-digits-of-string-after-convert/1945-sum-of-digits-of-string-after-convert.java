class Solution {
    public int getLucky(String s, int k) {
        String res = "";
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            res += (int)(s.charAt(i) - 'a' + 1); 
        }
        int ans = 0;
        while(k-->0){
            n = res.length();
            ans = 0;
            for(int i = 0 ; i < n ; i++){
                ans += Integer.parseInt(res.charAt(i)+"");
            }
            res = Integer.toString(ans);
        }
        return ans;
    }
}