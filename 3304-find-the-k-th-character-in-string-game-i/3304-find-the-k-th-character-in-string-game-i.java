class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        int temp = k;
        while(temp-- > 0 && word.length() < k){
            String res = "";
            for(char ch : word.toCharArray()){
                res += (char) ((ch - 'a' + 1) % 26 + 'a');
            }
            
            word += res;
        }
        // System.out.println(word);
        return word.charAt(k-1);
    }
}