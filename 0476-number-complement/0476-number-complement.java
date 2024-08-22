class Solution {
    public int findComplement(int num) {
        String s = Integer.toString(num,2);
        // System.out.println(s);
        String res = "";
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1') res += '0';
            else res += '1';
        }
        return Integer.parseInt(res,2);
    }
}