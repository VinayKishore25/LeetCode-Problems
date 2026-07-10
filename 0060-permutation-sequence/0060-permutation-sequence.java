class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[10];

        fact[0] = 1;

        for (int i = 1; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }

        boolean[] taken = new boolean[n + 1];

        StringBuilder sb = new StringBuilder();

        solve(n, n, k, fact, taken, sb);

        return sb.toString();
    }

    public void solve(
        int i,
        int n,
        int k,
        int[] fact,
        boolean[] taken,
        StringBuilder sb
    ) {

        if (i == 1) {
            for (int p = 1; p <= n; p++) {
                if (!taken[p]) {
                    sb.append(p);
                    return;
                }
            }
        }

        int currentValue = (k - 1) / fact[i - 1] + 1;

        int nextK =
            (k % fact[i - 1] == 0)
                ? fact[i - 1]
                : k % fact[i - 1];

        int temp = 0;

        for (int p = 1; p <= n; p++) {
            if (!taken[p]) {
                currentValue--;
            }

            if (currentValue == 0) {
                temp = p;
                break;
            }
        }

        taken[temp] = true;

        sb.append(temp);

        solve(i - 1, n, nextK, fact, taken, sb);
    }
}