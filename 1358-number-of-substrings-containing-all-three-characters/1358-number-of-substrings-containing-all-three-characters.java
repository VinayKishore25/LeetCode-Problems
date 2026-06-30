class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int n = s.length();
        int i = n - 1 , j = n - 1;
        int count = 0;
        while(i >= 0 && j >= 0){
            freq[s.charAt(i) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                count += i + 1;
                freq[s.charAt(j) - 'a']--;
                j--;
            }
            i--;
        }
        return count;
    }
}