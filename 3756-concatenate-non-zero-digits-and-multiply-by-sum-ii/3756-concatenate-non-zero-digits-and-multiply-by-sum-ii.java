class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        StringBuilder nonZero = new StringBuilder();
        long[] prefixSum = new long[n];
        int[] nonZeroIndex = new int[n];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch != '0') {
                nonZero.append(ch);
                cnt++;
            }

            nonZeroIndex[i] = cnt;
            prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + (ch - '0');
        }

        int m = nonZero.length();

        long[] pow10 = new long[m + 1];
        long[] prefixNum = new long[m + 1];

        pow10[0] = 1;

        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < m; i++) {
            prefixNum[i + 1] =
                    (prefixNum[i] * 10 + (nonZero.charAt(i) - '0')) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r] - (l == 0 ? 0 : prefixSum[l - 1]);

            int left = (l == 0) ? 0 : nonZeroIndex[l - 1];
            int right = nonZeroIndex[r];

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            long number =
                    (prefixNum[right]
                    - (prefixNum[left] * pow10[right - left]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((number * (sum % MOD)) % MOD);
        }

        return ans;
    }
}