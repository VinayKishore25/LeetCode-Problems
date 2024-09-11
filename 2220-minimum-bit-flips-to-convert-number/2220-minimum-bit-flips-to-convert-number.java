class Solution {
    public int minBitFlips(int start, int goal) {
        String st = Integer.toString(start,2);
        String gl = Integer.toString(goal,2);
        int n = st.length() - 1;
        int m = gl.length() - 1;
        int count = 0;
        while(n >= 0 && m >= 0 ){
            if(st.charAt(n) != gl.charAt(m)){
                count++;
            }
            n--;
            m--;
        }
        while(n >= 0){
            if(st.charAt(n) == '1'){
                count++;
            }
            n--;
        }
        while(m >= 0){
            if(gl.charAt(m) == '1'){
                count++;
            }
            m--;
        }
        return count;
    }
}