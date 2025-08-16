class Solution {
    public int maximum69Number (int num) {
        String res = Integer.toString(num);
        int n = res.length();
        String s = "";
        boolean flag = true;
        for(int i = 0 ; i < n ; i++){
            char ch = res.charAt(i);
            if(flag && ch == '6'){
                s += 9;
                flag = false;
            }
            else{
                s += ch;
            }
        }
        return Integer.parseInt(s);
    }
}