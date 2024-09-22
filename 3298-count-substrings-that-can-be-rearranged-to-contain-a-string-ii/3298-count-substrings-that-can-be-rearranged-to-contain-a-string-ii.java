class Solution {
    public long validSubstringCount(String word1, String word2) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int m = word1.length();
        int n = word2.length();
        for (char ch : word2.toCharArray()) {
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }

        int j = 0;
        long res = 0;

        for (int i = 0; i < m; i++) {
            char ch = word1.charAt(i);

            if (hm2.containsKey(ch)) {
                if (hm1.getOrDefault(ch, 0) < hm2.get(ch)) {
                    n--;
                }
            }

            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);

            while (n == 0) {
                res += m - i;

                char ch2 = word1.charAt(j);
                hm1.put(ch2, hm1.get(ch2) - 1);

                if (hm2.containsKey(ch2) && hm1.get(ch2) < hm2.get(ch2)) {
                    n++;
                }
                j++;
            }
        }
        return res;
    }
}