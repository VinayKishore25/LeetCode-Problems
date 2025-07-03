class Solution {
    static String word = "a";
    public static char kthCharacter(int k) {
        if(word.length() > k){
            return word.charAt(k-1);
        }
        int temp = k;
        while(temp-- > 0 && word.length() < k){
            String res = "";
            for(char ch : word.toCharArray()){
                res += (char) ((ch - 'a' + 1) % 26 + 'a');
            }
            
            word += res;
        }
        
        return word.charAt(k-1);
    }
}