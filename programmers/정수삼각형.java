class Solution {
    public int solution(int[][] tri) {
        int[][] dp = new int[tri.length][tri.length];
        dp[0][0] = tri[0][0];
        
        // dp[i][j] = Max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
        for (int i = 1; i < tri.length; i++) {
            // 맨 왼쪽 숫자
            dp[i][0] = dp[i-1][0] + tri[i][0];
            
            // 가운데
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
            }
            
            // 맨 오른쪽
            dp[i][i] = dp[i - 1][i-1] + tri[i][i];
        }
        
        int answer = 0;
        for (int i = 0; i < tri.length; i++) {
            answer = Math.max(answer, dp[tri.length-1][i]);
        }
        
        return answer;
    }
}
