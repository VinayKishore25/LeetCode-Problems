class Solution {
    public void makeChanges(int start, int end, int val,int[] prefix){
        for(int i = start; i <= end ; i++){
            prefix[i] += val;
        }
    }
    
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int l = shifts.length;
        int[] prefix = new int[n];
        HashMap<Integer,Character> hm = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++){
            hm.put(i,(char)(i+'a'));
        } 
        for(int i = 0 ; i < l ; i++){
            int val = 1;
            if(shifts[i][2] == 0){
                val = -1;
            }
            makeChanges(shifts[i][0],shifts[i][1],val,prefix);
        }
        String res = "";
        for(int i = 0 ; i < n ; i++ ){
            char ch = s.charAt(i);
            res += hm.get(((ch - 'a' + prefix[i])%26 + 26 ) % 26);
        }
        return res;
    }
}