class Solution {
    public boolean isSorted(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public int minOperations(String s) {
        int n = s.length();

        char minChar = '{';
        char maxChar = '_';
        int minPosition = n - 1, maxPosition = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(minChar > ch){
                minChar = ch;
                minPosition = i;
            }

            if(maxChar <= ch){
                maxChar = ch;
                maxPosition = i;
            }
        }
        if(n <= 2){
            if(isSorted(s)){
                return 0;
            }
            return -1;
        }
        if(isSorted(s)){
            return 0;
        }
        if(minPosition == 0 || maxPosition == n - 1){
            return 1;
        }
        else if(minPosition == n - 1 && maxPosition == 0){
            return 3;
        }
        else{
            return 2;
        }
    }
}