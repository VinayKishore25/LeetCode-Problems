class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int prefixZeroCount = 0;
        int countOne = 0;
        int suffixZeroCount = 0;
        int totalOnes = 0;
        int maximumSubarray = 0;
        for(char ch : s.toCharArray()){
            
            if(ch == '0'){
                if(countOne == 0){
                    prefixZeroCount++;
                }
                else{
                    suffixZeroCount++;
                }
            }
            else{
                if(prefixZeroCount != 0 && suffixZeroCount == 0){
                    countOne++;
                }
                else if(suffixZeroCount != 0){
                    maximumSubarray = Math.max(maximumSubarray,prefixZeroCount + suffixZeroCount);
                    prefixZeroCount = suffixZeroCount;
                    countOne = 1;
                    suffixZeroCount = 0;
                }
                totalOnes++;
            }
        }
        if(prefixZeroCount != 0 && suffixZeroCount != 0){
            maximumSubarray = Math.max(maximumSubarray,prefixZeroCount + suffixZeroCount);
        }

        return totalOnes + maximumSubarray;
    }
}
