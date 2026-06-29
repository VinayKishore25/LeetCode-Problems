class Solution {
    public boolean isVowel(char ch){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char vowel : vowels){
            if(ch == vowel){
                return true;
            }
        }
        return false;
    }
    public String reverseVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int left = 0 , right = n - 1;
        while(left < right){
            while(left < n && !isVowel(sb.charAt(left))){
                left++;
            }
            while(right > 0 && !isVowel(sb.charAt(right))){
                right--;
            }
            if(left >= right) break;
            char ch = sb.charAt(right);
            sb.setCharAt(right,sb.charAt(left));
            sb.setCharAt(left,ch);
            left++;
            right--;
        }
        return sb.toString();
    }
}