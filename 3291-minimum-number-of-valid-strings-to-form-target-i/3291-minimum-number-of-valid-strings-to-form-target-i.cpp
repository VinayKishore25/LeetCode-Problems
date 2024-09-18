class Solution {
public:
    int minValidStrings(vector<string>& words, string target) {
        int n = target.length();
        vector<int> dp(n + 1, INT_MAX);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INT_MAX) {
                continue;
            }
            for (const string& word : words) {
                int j = 0;
                while (i + j < n && j < word.length() && target[i + j] == word[j]) {
                    dp[i + j + 1] = min(dp[i + j + 1], dp[i] + 1);
                    j++;
                }
            }
        }

        return dp[n] == INT_MAX ? -1 : dp[n];
    }
};