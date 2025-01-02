class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n+1];
        String vowels = "aeiou";
        for(int i = 0 ; i < n ; i++){
            prefix[i + 1] = prefix[i];
            if (vowels.contains(words[i].charAt(0)+"") && vowels.contains(words[i].charAt(words[i].length() - 1)+"")) {
                prefix[i + 1]++;
            }
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] range : queries){
            ans[i++] = prefix[range[1] + 1] - prefix[range[0]];
        }
        return ans;
    }
}