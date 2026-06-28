class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int end = n - 1, start = n - 1;
        String res = "";
        String word = "";
        while(end >= 0){
            while(end >= 0 && s.charAt(end) == ' '){
                end--;
            }
            start = end;
            while(start >=0 && s.charAt(start) != ' '){
                word = s.charAt(start) + word;
                start--;
            }
            word += " ";
            res += word;
            word = "";
            end = start;
        }
        return res.trim();
    }
}