class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int sum = 1;
        char prev = word.charAt(0);
        for(int i = 1 ; i < n ; i++){
            char curr = word.charAt(i);
            if(curr == prev){
                sum += 1;
            }
            else{
                prev = curr;
            }
        }
        return sum;
    }
}