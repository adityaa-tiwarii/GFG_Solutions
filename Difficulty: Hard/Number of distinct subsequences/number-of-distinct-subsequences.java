class Solution {
    int distinctSubseq(String str) {
        int mod = 1000000007;
        int n = str.length();
        long[] dp = new long[n + 1];
        int[] last = new int[26];

        for (int i = 0; i < 26; i++) last[i] = -1;

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2) % mod;
            int c = str.charAt(i - 1) - 'a';
            if (last[c] != -1) dp[i] = (dp[i] - dp[last[c] - 1] + mod) % mod;
            last[c] = i;
        }

        return (int) dp[n];
    }
}