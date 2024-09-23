class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int m = word1.length();
        int n = word2.length();

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        long res = 0;
        int count = 0;
        int j = 0;

        for (int i = 0; i < m; i++) {
            char ch = word1.charAt(i);
            freq1[ch - 'a']++;

            if (freq1[ch - 'a'] <= freq2[ch - 'a']) {
                count++;
            }

            while (count == n) {
                res += m - i;

                char ch2 = word1.charAt(j);
                freq1[ch2 - 'a']--;

                if (freq1[ch2 - 'a'] < freq2[ch2 - 'a']) {
                    count--;
                }
                j++;
            }
        }
        return res;
    }
}
