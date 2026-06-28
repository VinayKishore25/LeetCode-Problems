class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String res = "";
        String word = "";
        s = " " + s;
        int n = s.length();
        int i = n - 1;
        while(i >= 0){
            char ch = s.charAt(i);
            if(ch == ' ' || i == 0){
                while(i >= 0 && s.charAt(i) == ' '){
                    i--;
                }
                res += word;
                if(i > 0){
                    res += " ";
                }
                word = "";
                continue;
            }
            else {
                word = ch + word;
                i--;
            }
        }
        return res;
    }
}