class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        int minWhite = whiteCount;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            minWhite = Math.min(minWhite, whiteCount);
        }
        
        return minWhite;
    }
}