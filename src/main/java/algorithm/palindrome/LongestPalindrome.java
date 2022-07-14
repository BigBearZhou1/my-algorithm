package algorithm.palindrome;


public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int m = s.length();
        boolean[][] dp = new boolean[m][m];

        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
        }

        int longest = 1;
        int beginIdx = 0;

        for (int len = 2; len < m + 1; len++) {
            for (int i = 0; i < m - len + 1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                } else {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && len > longest) {
                    longest = len;
                    beginIdx = i;
                }
            }
        }
        return s.substring(beginIdx, beginIdx + longest);
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String res = solution.longestPalindrome("bb");
        System.out.println(res);
    }
}
