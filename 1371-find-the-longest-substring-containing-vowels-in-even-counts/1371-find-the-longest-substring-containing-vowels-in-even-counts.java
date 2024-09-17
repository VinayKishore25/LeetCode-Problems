class Solution {
    public int findTheLongestSubstring(String s) {
        int prefix = 0;
        int[] vowels = new int[26];
        vowels['a' - 'a'] = 1;
        vowels['e' - 'a'] = 2;
        vowels['i' - 'a'] = 4;
        vowels['o' - 'a'] = 8;
        vowels['u' - 'a'] = 16;
        int n = s.length();
        HashMap<Integer,Integer> hm = new HashMap<>();
        // hm.put(0,-1);
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            prefix ^= vowels[s.charAt(i) - 'a'];
            System.out.println(prefix);
            if(!hm.containsKey(prefix) && prefix != 0){
                hm.put(prefix,i);
            }
            int prev = hm.containsKey(prefix) ? hm.get(prefix) : -1;
            res = Math.max(res,i - prev);
        }
        System.out.println(hm);
        return res;
    }
}