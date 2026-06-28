class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int end = n, start = n - 1;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while(end >= 0){
            while(end > 0 && s.charAt(end - 1) == ' '){
                end--;
            }
            if(end == 0) break;
            start = end;
            while(start > 0 && s.charAt(start - 1) != ' '){
                start--;
            }
            if(flag){
                sb.append(" ");
            }
            flag = true;
            sb.append(s.substring(start,end));
            end = start;
        }
        return sb.toString();
    }
}