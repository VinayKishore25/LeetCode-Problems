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
        char[] ch = s.toCharArray();
        int left = 0 , right = n - 1;
        while(left < right){
            while(left < n && !isVowel(ch[left])){
                left++;
            }
            while(right > 0 && !isVowel(ch[right])){
                right--;
            }
            if(left >= right) break;
            char temp = ch[right];
            ch[right] = ch[left];
            ch[left] = temp;
            left++;
            right--;
        }
        return new String(ch);
    }
}