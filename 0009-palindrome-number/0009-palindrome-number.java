class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        if(x < 0){
            return false;
        } else{
            int reverseNumber = 0;
            while(x > 0){
                reverseNumber = reverseNumber * 10 + x % 10;
                x = x / 10;
            }
            if(reverseNumber == temp){
                return true;
            } else {
                return false;
            }
        }
    }
}