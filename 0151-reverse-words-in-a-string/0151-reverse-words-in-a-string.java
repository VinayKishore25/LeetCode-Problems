class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int end = n, start = n - 1;
        String res = "";
        String word = "";
        boolean flag = false;
        while(end >= 0){
            while(end > 0 && s.charAt(end - 1) == ' '){
                end--;
            }
            if(end == 0) break;
            start = end;
            while(start > 0 && s.charAt(start - 1) != ' '){
                word = s.charAt(start - 1) + word;
                start--;
            }
            if(flag){
                res += " ";
            }
            flag = true;
            res += word;
            word = "";
            end = start;
        }
        return res;
    }
}